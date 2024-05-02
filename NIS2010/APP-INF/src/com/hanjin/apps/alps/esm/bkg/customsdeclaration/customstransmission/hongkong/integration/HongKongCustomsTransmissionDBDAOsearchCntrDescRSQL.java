/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : HongKongCustomsTransmissionDBDAOsearchCntrDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HongKongCustomsTransmissionDBDAOsearchCntrDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 홍콩세관 신고용 Manifest Container Description 정보를 조회한다.
	  * </pre>
	  */
	public HongKongCustomsTransmissionDBDAOsearchCntrDescRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.integration").append("\n"); 
		query.append("FileName : HongKongCustomsTransmissionDBDAOsearchCntrDescRSQL").append("\n"); 
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
		query.append("'D_CMDT:'||'' D_CMDT," ).append("\n"); 
		query.append("'D_PUNIT:'||NVL(PCK_TP_CD,'') D_PUNIT," ).append("\n"); 
		query.append("'D_PKG:'||NVL(PCK_QTY,0) D_PKG," ).append("\n"); 
		query.append("'D_WUNIT:'||NVL(WGT_UT_CD,'') D_WUNIT," ).append("\n"); 
		query.append("'D_WGT:'||DECODE(NVL(WGT_UT_CD,''),'LBS',ROUND(NVL(CNTR_MF_WGT,0)*0.4536,3),NVL(CNTR_MF_WGT,0)) D_WGT," ).append("\n"); 
		query.append("'D_MUNIT:'||NVL(MEAS_UT_CD,'') D_MUNIT," ).append("\n"); 
		query.append("'D_MEAS:'||DECODE(NVL(MEAS_UT_CD,''),'CBF',ROUND(NVL(MEAS_QTY,0)*0.0283,3),NVL(MEAS_QTY,0)) D_MEAS," ).append("\n"); 
		query.append("'D_DESC:'||REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(TRANSLATE(NVL(CNTR_MF_GDS_DESC,' '),CHR(13)||CHR(10),' '),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)) d_desc," ).append("\n"); 
		query.append("DECODE(CNTR_MF_MK_DESC,NULL,'', REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(Translate(NVL(CNTR_MF_MK_DESC,''),CHR(13)||CHR(10),''),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59))||CHR(10)||'') cus_mark" ).append("\n"); 
		query.append("FROM  BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("WHERE BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("and   CNTR_NO(+)    = @[cntr_no]" ).append("\n"); 

	}
}