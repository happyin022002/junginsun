/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceVVDDualRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2010.03.09 박재흥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceVVDDualRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTerminalInvoiceVVDDual
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceVVDDualRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceVVDDualRSQL").append("\n"); 
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
		query.append("-- VVD BOUND 자동 배분 체크 동일 Yard, Atb Date에 항차가 ± 1 까지 조회" ).append("\n"); 
		query.append("-- 반대 방향의 배는 반드시 한개만 존재한다고 하나 만약의 경우를 대비 Rownum처리 - ( 4342. 01. 19 이경한 과장 요청 CSR )" ).append("\n"); 
		query.append("SELECT	VSL_CD VVD_VSL_CD, SKD_VOY_NO VVD_SKD_VOY_NO, SKD_DIR_CD VVD_SKD_DIR_CD, TO_CHAR(VPS_ETB_DT,'YYYY-MM-DD') VVD_ATB_DT" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE	VPS_PORT_CD	= SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append("AND		VSL_CD		= SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("-- DB 형변환 문제로 인하여 변경 - 특이한 경우 발생 ( 2009-07-23 )" ).append("\n"); 
		query.append("AND	( SKD_VOY_NO  = TO_CHAR( SUBSTR(@[vvd],5,4) )" ).append("\n"); 
		query.append("OR SKD_VOY_NO  = LPAD(TO_CHAR( TO_NUMBER( SUBSTR(@[vvd],5,4) ) + 1 ),4,'0')" ).append("\n"); 
		query.append("OR SKD_VOY_NO  = LPAD(TO_CHAR( TO_NUMBER( SUBSTR(@[vvd],5,4) ) - 1 ),4,'0'))" ).append("\n"); 
		query.append("AND	SKD_DIR_CD  = DECODE(SUBSTR(@[vvd],9,1),'E','W','W','E','S','N','N','S')" ).append("\n"); 
		query.append("AND TO_CHAR(VPS_ETB_DT,'YYYY-MM-DD')	= @[atb_dt]" ).append("\n"); 
		query.append("AND	ROWNUM	= 1" ).append("\n"); 

	}
}