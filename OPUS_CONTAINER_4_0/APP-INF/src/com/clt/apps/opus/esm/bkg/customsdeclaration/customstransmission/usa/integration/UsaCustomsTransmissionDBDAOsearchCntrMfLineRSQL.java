/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCntrMfLineRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.06
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.01.06 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM MINJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchCntrMfLineRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCntrMfLineRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCntrMfLineRSQL").append("\n"); 
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
		query.append("SELECT NVL(CMDT_GDS_SEQ,'00') cmd_seq, NVL(HAMO_CMDT_CD,' ') icm_ht_cd," ).append("\n"); 
		query.append("		SUBSTR(TO_CHAR(GRS_WGT*20,'09999999'),2) icm_wgt_val," ).append("\n"); 
		query.append("		SUBSTR(TO_CHAR(GRS_WGT,'0999999999'),2) icm_wgt_qty," ).append("\n"); 
		query.append("		NVL(SUBSTR(WGT_UT_CD, 1, 2),'KG') icm_wgt_tp," ).append("\n"); 
		query.append("		SUBSTR(TO_CHAR(PCK_QTY,'0999999999'),2) icm_pkg_qty," ).append("\n"); 
		query.append("        DECODE(NVL(CGO_DESC,' '),' ',SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(@[cmdt_desc],' '),'M'),1,45)" ).append("\n"); 
		query.append("            ,SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(CGO_DESC,' '),'M'),1,45)) icm_desc" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	FROM BKG_CSTMS_ADV_CNTR_MF" ).append("\n"); 
		query.append("	WHERE " ).append("\n"); 
		query.append("		BL_NO = @[bl_no]" ).append("\n"); 
		query.append("		AND CNTR_NO    = TRIM(@[cntr_no])" ).append("\n"); 
		query.append("		AND CNT_CD = 'US'" ).append("\n"); 

	}
}