Dim dataArr()
Function CreateVBArray(rows,cols,skipStr)
'MsgBox(rows & "," & cols)
	ReDim dataArr(rows,cols)
	  For vbI = 0 To rows 
		For vbJ = 0 To cols 
		  dataArr(vbI, vbJ) = skipStr
		Next
	  Next
End Function

Function SetVBValue(row,col,value)
'MsgBox(row & "," & col & "," & value)
	dataArr(row,col) = value
End Function

Function GetVBValue(row,col)
'MsgBox(row & "," & col & "," & value)
	GetVBValue=dataArr(row,col) 
End Function

Function GetVBArray()
	GetVBArray=dataArr
End Function