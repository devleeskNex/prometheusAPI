###Prometheus API
##### endpoint

+ Instant queries
	
		GET /api/v1/query

	+ input
		+ query
		+ time
		+ timeout

	+ output
		+ resultType
			+ matrix
			+ vector
			+ scalar
			+ string
		
		+ result
			+ value

	+ ex
		+ http://192.168.0.172:22222/api/v1/query?query=up&time=2019-01-02T04:13:43.000Z
		
				{
				  "status": "success",
				  "data": {
				    "resultType": "vector",
				    "result": [
				      {
						"metric": {
						  "__name__": "up",
						  "app": "prometheus",
						  "chart": "prometheus-8.3.0",
						  "component": "kube-state-metrics",
						  "heritage": "Tiller",
						  "instance": "10.244.4.174:8080",
						  "io_cattle_field_appId": "prometheuslsk",
						  "job": "kubernetes-service-endpoints",
						  "kubernetes_name": "prometheuslsk-kube-state-metrics",
						  "kubernetes_namespace": "prometheus",
						  "kubernetes_node": "kubenode4",
						  "release": "prometheuslsk"
						},
						"value": [
						  1546402423,
						  "1"
						]
				      }
				    ]
				  }
				}

+ Range queries

		GET /api/v1/query_range

	+ input
		+ query
		+ start
		+ end
		+ step
 		+ timeout
 	
	+ output
		+ resultType
			+ matrix
		
		+ result
			+ value
 	
+ meta query

		GET /api/v1/series
		
	+ ex
	
			http://192.168.0.172:22222/api/v1/series?match[]=up&match[]=process_start_time_seconds{job=%22prometheus%22}

+ Getting label names

		GET /api/v1/labels
		POST /api/v1/labels
		
	+ ex
	
			http://192.168.0.172:22222/api/v1/labels
			{
			  "status": "success",
			  "data": [
			    "__name__",
			    "address",
			    "alertmanager",
			    "annotation_cattle_io_appIds",
			    "annotation_cattle_io_status",
			    "container_id",
			    "container_name",
			    "container_runtime_version",
			    "contentType",
			    "controller_class",
			    "controller_namespace",
			    "controller_pod",
			    "cpu"
			  ]
			}

+ Querying label values

		GET /api/v1/label/<label_name>/values

	+ ex
	
			http://192.168.0.172:22222/api/v1/label/cpu/values

+ 모든 메트릭

		GET /api/v1/label/__name__/values
		
	+ ex
	
			http://192.168.0.172:22222/api/v1/label/__name__/values

+ 특정 메트릭

	+ ex
	
			http://192.168.0.172:22222/api/v1/series?match[]=DiscoveryController_queue_latency

+ target

		GET /api/v1/targets


+ target meta


	+ ex
	
			curl -G http://192.168.0.172:22222/api/v1/targets/metadata     --data-urlencode 'metric=go_goroutines'     --data-urlencode 'match_target={job="prometheus"}'     --data-urlencode 'limit=2'
			{
			  "status": "success",
			  "data": [
			    {
			      "target": {
				"instance": "localhost:9090",
				"job": "prometheus"
			      },
			      "type": "gauge",
			      "help": "Number of goroutines that currently exist.",
			      "unit": ""
			    }
			  ]
			}

+ rules

		GET /api/v1/rules

	+ ex 
	
			http://192.168.0.172:22222/api/v1/rules
			{
			  "status": "success",
			  "data": {
			    "groups": [
			      
			    ]
			  }
			}
			
+ alerts

		GET /api/v1/alerts
		
	+ ex
	
			http://192.168.0.172:22222/api/v1/alerts
			{
			  "status": "success",
			  "data": {
			    "alerts": [
			      
			    ]
			  }
			}
			
+ alertmanager

		GET /api/v1/alertmanagers
	
	+ ex
	
			http://192.168.0.172:22222/api/v1/alertmanagers
			{
			  "status": "success",
			  "data": {
			    "activeAlertmanagers": [
			      {
				"url": "http://10.244.2.158:9093/api/v1/alerts"
			      }
			    ],
			    "droppedAlertmanagers": [
			      {
				"url": "http://192.168.0.178/api/v1/alerts"
			      }
			    ]
			  }
			}
			
+ status

		GET /api/v1/status/config
		
	+ ex

			http://192.168.0.172:22222/api/v1/status/config
			{
			  "status": "success",
			  "data": {
			    "yaml": "yaml info"
			  }
			}
			
