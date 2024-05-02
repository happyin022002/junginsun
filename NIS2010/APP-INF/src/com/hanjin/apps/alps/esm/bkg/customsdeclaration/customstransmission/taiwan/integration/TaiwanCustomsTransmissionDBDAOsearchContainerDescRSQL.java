/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TaiwanCustomsTransmissionDBDAOsearchContainerDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TaiwanCustomsTransmissionDBDAOsearchContainerDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 대만세관 신고용 Manifest Container Description 정보를 조회한다.
	  * </pre>
	  */
	public TaiwanCustomsTransmissionDBDAOsearchContainerDescRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.integration").append("\n"); 
		query.append("FileName : TaiwanCustomsTransmissionDBDAOsearchContainerDescRSQL").append("\n"); 
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
		query.append("' ' d_cmdt," ).append("\n"); 
		query.append("NVL(PCK_TP_CD,' ') d_punit," ).append("\n"); 
		query.append("NVL(PCK_QTY,0) d_pkg," ).append("\n"); 
		query.append("DECODE(NVL(WGT_UT_CD,' '),'LBS',ROUND(NVL(CNTR_MF_WGT,0)*0.4536,3),NVL(CNTR_MF_WGT,0)) d_wgt," ).append("\n"); 
		query.append("DECODE(NVL(MEAS_UT_CD,' '),'CBF',ROUND(NVL(MEAS_QTY,0)*0.0283,3),NVL(MEAS_QTY,0)) d_mea," ).append("\n"); 
		query.append("TRANSLATE(NVL(CNTR_MF_GDS_DESC,' '),CHR(13)||CHR(10),' ') cntr_desc," ).append("\n"); 
		query.append("DECODE(CNTR_MF_MK_DESC,NULL,'','{CUS_MARK'||CHR(10)||'D_MARK:' ||REPLACE(CNTR_MF_MK_DESC,CHR(13)||CHR(10),CHR(10)||'D_MARK:')||CHR(10)||'}CUS_MARK'||CHR(10) )  st_13" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM  BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("WHERE BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("AND CNTR_NO(+)    = @[cntr_no]" ).append("\n"); 

	}
}