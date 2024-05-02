/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ControlOfficeExceptionCaseManageDBDAOSearchControlOfficeExceptionCaseManageListRSQLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.controlofficeexceptioncasemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ControlOfficeExceptionCaseManageDBDAOSearchControlOfficeExceptionCaseManageListRSQLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Exception Control Office를 조회
	  * </pre>
	  */
	public ControlOfficeExceptionCaseManageDBDAOSearchControlOfficeExceptionCaseManageListRSQLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.controlofficeexceptioncasemanage.integration").append("\n"); 
		query.append("FileName : ControlOfficeExceptionCaseManageDBDAOSearchControlOfficeExceptionCaseManageListRSQLRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("		 		SUBSTR(FM_NOD_CD,1,5)				AS FM_LOC_VALUE" ).append("\n"); 
		query.append("		  ,	SUBSTR(FM_NOD_CD,6,2)				AS FM_YARD_VALUE" ).append("\n"); 
		query.append("		  ,   	SUBSTR(TO_NOD_CD,1,5)				AS TO_LOC_VALUE" ).append("\n"); 
		query.append("		  ,	SUBSTR(TO_NOD_CD,6,2)				AS TO_YARD_VALUE" ).append("\n"); 
		query.append("		  ,	SUBSTR(VIA_NOD_CD,1,5)				AS VIA_LOC_VALUE" ).append("\n"); 
		query.append("		  ,	SUBSTR(VIA_NOD_CD,6,2)				AS VIA_YARD_VALUE" ).append("\n"); 
		query.append("		  ,	SUBSTR(DOR_NOD_CD,1,5)				AS DOR_LOC_VALUE" ).append("\n"); 
		query.append("		  ,	SUBSTR(DOR_NOD_CD,6,2)				AS DOR_YARD_VALUE" ).append("\n"); 
		query.append("		  ,	CTRL_OFC_DIV_CD" ).append("\n"); 
		query.append("		  ,	CTRL_OFC_CD" ).append("\n"); 
		query.append("		  ,	CGO_TP_CD" ).append("\n"); 
		query.append("		  ,	NVL(A.DELT_FLG, 'N')				AS DELT_FLG" ).append("\n"); 
		query.append("		  ,	DELT_FLG							AS ORG_DELT_FLG" ).append("\n"); 
		query.append("		  ,	CRE_OFC_CD" ).append("\n"); 
		query.append("		  ,	A.CRE_USR_ID" ).append("\n"); 
		query.append("		  ,	TO_CHAR(A.CRE_DT,'YYYYMMDD')		AS CRE_DT" ).append("\n"); 
		query.append("		  ,	DECODE(DELT_FLG,'Y','1','0')		AS DELCHECK" ).append("\n"); 
		query.append("		  ,	DECODE(DELT_FLG,'Y',UPD_USR_ID, '')	AS UPD_USR_ID" ).append("\n"); 
		query.append("		  ,	DECODE(DELT_FLG,'Y',TO_CHAR(A.UPD_DT,'YYYYMMDD'), '')	AS UPD_DT" ).append("\n"); 
		query.append("		  ,	FM_NOD_CD" ).append("\n"); 
		query.append("		  ,	TO_NOD_CD" ).append("\n"); 
		query.append("		  ,	VIA_NOD_CD" ).append("\n"); 
		query.append("		  ,	DOR_NOD_CD" ).append("\n"); 
		query.append("		  ,	TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("		  ,	TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("		  ,	CNTR_TP_CD" ).append("\n"); 
		query.append("		  ,	CNTR_SZ_CD" ).append("\n"); 
		query.append("		  FROM" ).append("\n"); 
		query.append("		  		TRS_TRSP_OFC_EXPT_RULE A" ).append("\n"); 
		query.append("ORDER BY FM_NOD_CD, TO_NOD_CD, VIA_NOD_CD, DOR_NOD_CD" ).append("\n"); 

	}
}