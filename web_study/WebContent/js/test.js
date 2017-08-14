/**
 * 
 */

function checkValue(fObj) {
	var maxNum = fObj.elements.length;

	var result = "";
	for (var i = 0; i < maxNum; i++) {
		var eObj = fObj.elements[i];
		if (eObj.value.indexOf("빡쌤") != -1) {
			alert("뒤질라고!!");
			eObj.value = "";
			eObj.focus();
		}
//		if (i % 2 == 1 && i != maxNum - 1) {
//			var checkNum = new Number(eObj.value);
//			try{
//				if (isNan(checkNum)) {
//					alert("숫자라고!!!!!!!!!");
//					eObj.value = "";
//					eObj.focus();
//					return false;
//				}
//			}catch(e){
//				alert(e);
//			}
//		}
//		if (eObj.value != "전송") {
//			result += eObj.value;
//		}
//		if (i == maxNum - 1) {
//			eObj.value = result;
//		}
	}
//	var eObj1 = fObj.elements[0];
//	var eObj2 = fObj.elements[1];
//	var eObj3 = fObj.elements[3];
//	eObj3.value = eObj1.value + eObj2.value;

	return false;
}