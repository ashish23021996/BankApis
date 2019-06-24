#!/bin/bash
                                #fetching all details of branches, given bank name and a city

city_name="MUMBAI"
bank_name="ABHYUDAYA COOPERATIVE BANK LIMITED"
bank_name=${bank_name// /%20}
city_name=${city_name// /%20}


limit="2"
offset="0"
 X="-X GET"
url="--url https://bankapis.herokuapp.com/api/Branches?city_name=${city_name}&bank_name=${bank_name}&limit=${limit}&offset=${offset}"
echo -e "fetching all details of branches, given bank name and a city:\n"
curl ${X}  ${url} -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJTT01FSUQxMjM0IiwiaWF0IjoxNTYxMTAxMDgyLCJzdWIiOiJBc2hpc2giLCJpc3MiOiJKV1QgRGVtbyIsImV4cCI6MTU2MTUzMzA4Mn0.6y7-bs-T_WejQ2UnxS77bqtkSsaP-jdgzzO093O_vJE" --silent --insecure
								
								
								
								#fetching all details of banks, given ifsc code
								
ifsc="ABHY0065010"								
url="--url https://bankapis.herokuapp.com/api/Banks?ifsc=${ifsc}&limit=${limit}&offset=${offset}"
 echo -e "\n\n\n fetching all details of banks, given ifsc code:\n"
curl ${X}  ${url} -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJTT01FSUQxMjM0IiwiaWF0IjoxNTYxMTAxMDgyLCJzdWIiOiJBc2hpc2giLCJpc3MiOiJKV1QgRGVtbyIsImV4cCI6MTU2MTUzMzA4Mn0.6y7-bs-T_WejQ2UnxS77bqtkSsaP-jdgzzO093O_vJE" --silent --insecure


