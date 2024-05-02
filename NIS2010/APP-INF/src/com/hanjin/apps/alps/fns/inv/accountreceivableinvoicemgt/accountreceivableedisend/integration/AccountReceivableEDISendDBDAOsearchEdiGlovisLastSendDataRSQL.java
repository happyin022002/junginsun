/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOsearchEdiGlovisLastSendDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.28
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2011.04.28 임창빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang-Bin Lim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOsearchEdiGlovisLastSendDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 청구 승인 상태인지 확인 하는 query
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOsearchEdiGlovisLastSendDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOsearchEdiGlovisLastSendDataRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT /*+INDEX_DESC(T XAK1INV_EDI_GLOVIS_HDR) */" ).append("\n"); 
		query.append("       AR_IF_NO" ).append("\n"); 
		query.append("       , IF_SEQ" ).append("\n"); 
		query.append("       , BL_SRC_NO" ).append("\n"); 
		query.append("       , GLOVIS_EDI_MSG_NO" ).append("\n"); 
		query.append("       , INV_NO" ).append("\n"); 
		query.append("       -- 최종 데이터가 청구 승인(A), 청구 반려(R), 접수 오류(F) 만을 확인한다." ).append("\n"); 
		query.append("       , (SELECT /*+INDEX_DESC(S XAK1INV_EDI_GLOVIS_HDR) */" ).append("\n"); 
		query.append("                  NVL(MAX(RE_TP_CD), ' ') AS RE_TP_CD " ).append("\n"); 
		query.append("          FROM    INV_EDI_GLOVIS_HDR S " ).append("\n"); 
		query.append("          WHERE   S.BL_SRC_NO = T.BL_SRC_NO" ).append("\n"); 
		query.append("          AND     S.RE_TP_CD  IN ('A', 'R', 'F')" ).append("\n"); 
		query.append("          AND     ROWNUM      = 1) AS RE_TP_CD" ).append("\n"); 
		query.append("       -- 전송 데이터 중에 청구 승인(A)을 받은 데이터가 있을  경우 리턴('Y') 받고 차액 전송할 수 있도록 한다." ).append("\n"); 
		query.append("       , (SELECT /*+INDEX_DESC(S XAK1INV_EDI_GLOVIS_HDR) */" ).append("\n"); 
		query.append("                  DECODE(RE_TP_CD, 'A', 'Y', 'N')" ).append("\n"); 
		query.append("          FROM    INV_EDI_GLOVIS_HDR S " ).append("\n"); 
		query.append("          WHERE   S.BL_SRC_NO = T.BL_SRC_NO" ).append("\n"); 
		query.append("          AND     S.RE_TP_CD  = 'A'" ).append("\n"); 
		query.append("          AND     ROWNUM      = 1) AS CXL_FLG" ).append("\n"); 
		query.append("       -- A 청구 승인, R : 청구 반려" ).append("\n"); 
		query.append("       -- 최종 Status가 청구 승인(A), 청구 반려(R), 접수 오류(F) 이거나, Cancel(Y)일 경우" ).append("\n"); 
		query.append("       -- 다음 데이터는 Cancel 데이터를 만들지 않고 입력 받은 자신이 바로 생성되게 한다." ).append("\n"); 
		query.append("       -- 0 이면 Cancel 데이터 미생성, 1 이면 Cancel 데이터 생성" ).append("\n"); 
		query.append("       , CASE WHEN (RE_TP_CD IN ('A', 'R', 'F') OR CXL_FLG = 'Y') THEN 0 ELSE 1 END INV_SEQ" ).append("\n"); 
		query.append("FROM   INV_EDI_GLOVIS_HDR T" ).append("\n"); 
		query.append("WHERE  BL_SRC_NO    = @[bl_src_no]" ).append("\n"); 
		query.append("AND    ROWNUM         = 1" ).append("\n"); 

	}
}