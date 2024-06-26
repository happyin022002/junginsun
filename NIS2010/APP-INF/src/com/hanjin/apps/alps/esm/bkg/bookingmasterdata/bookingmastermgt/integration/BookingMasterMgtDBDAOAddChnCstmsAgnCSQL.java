/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BookingMasterMgtDBDAOAddChnCstmsAgnCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.15
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2013.05.15 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOAddChnCstmsAgnCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Chinese EDI Agent등록(BKG_CSTMS_CHN_AGN_STUP)
	  * </pre>
	  */
	public BookingMasterMgtDBDAOAddChnCstmsAgnCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_cstms_agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_cstms_agn_full_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_cstms_agn_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_cstms_agn_pic_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_cstms_agn_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_cstms_agn_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_cstms_agn_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_cstms_agn_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOAddChnCstmsAgnCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_CHN_AGN_STUP (" ).append("\n"); 
		query.append("    AGN_CTRL_OFC_CD," ).append("\n"); 
		query.append("    POD_CD," ).append("\n"); 
		query.append("    CHN_CSTMS_AGN_CD," ).append("\n"); 
		query.append("    SLAN_CD," ).append("\n"); 
		query.append("    CHN_CSTMS_AGN_NM," ).append("\n"); 
		query.append("    EDI_RCV_ID," ).append("\n"); 
		query.append("    EDI_SND_ID," ).append("\n"); 
		query.append("    CHN_CSTMS_AGN_RMK," ).append("\n"); 
		query.append("	CHN_CSTMS_AGN_FULL_NM  ," ).append("\n"); 
		query.append("	CHN_CSTMS_AGN_PIC_NM   ," ).append("\n"); 
		query.append("	CHN_CSTMS_AGN_PHN_NO   ," ).append("\n"); 
		query.append("	CHN_CSTMS_AGN_EML      ," ).append("\n"); 
		query.append("	CHN_CSTMS_AGN_ADDR     ," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_OFC_CD," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("    @[agn_ctrl_ofc_cd]," ).append("\n"); 
		query.append("    @[pod_cd]," ).append("\n"); 
		query.append("    @[chn_cstms_agn_cd]," ).append("\n"); 
		query.append("    @[slan_cd]," ).append("\n"); 
		query.append("    @[chn_cstms_agn_nm]," ).append("\n"); 
		query.append("    @[edi_rcv_id]," ).append("\n"); 
		query.append("    @[edi_snd_id]," ).append("\n"); 
		query.append("    @[chn_cstms_agn_rmk]," ).append("\n"); 
		query.append("	@[chn_cstms_agn_full_nm]  ," ).append("\n"); 
		query.append("	@[chn_cstms_agn_pic_nm]   ," ).append("\n"); 
		query.append("	@[chn_cstms_agn_phn_no]   ," ).append("\n"); 
		query.append("	@[chn_cstms_agn_eml]      ," ).append("\n"); 
		query.append("	@[chn_cstms_agn_addr]     ," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    @[cre_ofc_cd]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[upd_usr_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}