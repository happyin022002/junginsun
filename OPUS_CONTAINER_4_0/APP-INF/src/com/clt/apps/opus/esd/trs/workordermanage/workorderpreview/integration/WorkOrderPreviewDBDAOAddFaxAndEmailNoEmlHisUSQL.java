/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddFaxAndEmailNoEmlHisUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.06
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.04.06 양봉준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOAddFaxAndEmailNoEmlHisUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddFaxAndEmailNoEmlHis
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddFaxAndEmailNoEmlHisUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_no_01",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_no_02",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_no_03",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOAddFaxAndEmailNoEmlHisUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_WRK_ORD_HIS" ).append("\n"); 
		query.append("SET wo_n1st_eml_snd_no = @[eml_no_01]" ).append("\n"); 
		query.append(",wo_n2nd_eml_snd_no = @[eml_no_02]" ).append("\n"); 
		query.append(",wo_n3rd_eml_snd_no = @[eml_no_03]" ).append("\n"); 
		query.append("WHERE (TRSP_WO_OFC_CTY_CD,TRSP_WO_SEQ,WO_ISS_KNT) IN" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("MAX(TRSP_WO_OFC_CTY_CD) TRSP_WO_OFC_CTY_CD ," ).append("\n"); 
		query.append("MAX(TRSP_WO_SEQ) TRSP_WO_SEQ," ).append("\n"); 
		query.append("MAX(WO_ISS_KNT) WO_ISS_KNT" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD_HIS" ).append("\n"); 
		query.append("WHERE TRSP_WO_OFC_CTY_CD = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("AND TRSP_WO_SEQ = @[trsp_wo_seq] )" ).append("\n"); 

	}
}