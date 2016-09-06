#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

void *Hebra (void *argumento) {

	while(1);

	return NULL;
}

int main (void) {
	
	int i=0;
	pthread_t thread;

	while(1){

		printf("Creando hebra %d\n",i);
		pthread_create(&thread, NULL, Hebra, NULL);
		++i;
	}

}
