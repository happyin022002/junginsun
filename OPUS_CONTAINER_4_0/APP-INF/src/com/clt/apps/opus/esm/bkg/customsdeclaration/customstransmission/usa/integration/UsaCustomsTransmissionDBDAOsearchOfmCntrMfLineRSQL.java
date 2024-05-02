/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchOfmCntrMfLineRSQL.java
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

public class UsaCustomsTransmissionDBDAOsearchOfmCntrMfLineRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim Ofm생성을 위한 CNTR_MF 조회
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchOfmCntrMfLineRSQL(){
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
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchOfmCntrMfLineRSQL").append("\n"); 
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
		query.append("		GRS_WGT*20 icm_wgt_val," ).append("\n"); 
		query.append("		GRS_WGT icm_wgt_qty," ).append("\n"); 
		query.append("		NVL(WGT_UT_CD,'KG') icm_wgt_tp," ).append("\n"); 
		query.append("		PCK_QTY icm_pkg_qty," ).append("\n"); 
		query.append("		DECODE(NVL(CGO_DESC,' '),' ',BKG_SPCLCHAR_CONV_FNC(NVL(@[cmdt_desc],' '),'M'),BKG_SPCLCHAR_CONV_FNC(NVL(CGO_DESC,' '),'M')) icm_desc" ).append("\n"); 
		query.append("	FROM BKG_CSTMS_ADV_CNTR_MF" ).append("\n"); 
		query.append("	WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("	  AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("	  AND CNTR_NO    = TRIM(@[cntr_no])" ).append("\n"); 

	}
}