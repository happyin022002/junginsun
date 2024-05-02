/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BookingProcessMgtDBDAOModifyCgoClzTmUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.20
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2013.03.20 조원주
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

public class BookingProcessMgtDBDAOModifyCgoClzTmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cargo closing time setup UPDATE
	  * </pre>
	  */
	public BookingProcessMgtDBDAOModifyCgoClzTmUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_ntc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mbl_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_pic_ntc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_ntc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_mphn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pic_ntc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eml_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_ntc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingProcessMgtDBDAOModifyCgoClzTmUSQL").append("\n"); 
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
		query.append("UPDATE 	BKG_CGO_CLZ_TM_STUP" ).append("\n"); 
		query.append("SET		POL_CD				= @[pol_cd]" ).append("\n"); 
		query.append("		,LANE_CD			= @[lane_cd]	" ).append("\n"); 
		query.append("		,DIR_CD				= @[dir_cd]" ).append("\n"); 
		query.append("		,CCT_HRS			= SUBSTR(@[cct_hrs],1,1)||REPLACE(SUBSTR(@[cct_hrs],2),'-','')" ).append("\n"); 
		query.append("		,EML_SND_FLG		= DECODE(@[eml_snd_flg],'1','Y','N')" ).append("\n"); 
		query.append("		,MBL_SND_FLG		= DECODE(@[mbl_snd_flg],'1','Y','N')" ).append("\n"); 
		query.append("		,SHPR_NTC_FLG		= DECODE(@[shpr_ntc_flg],'1','Y','N')" ).append("\n"); 
		query.append("		,BKG_PIC_NTC_FLG	= DECODE(@[bkg_pic_ntc_flg],'1','Y','N')" ).append("\n"); 
		query.append("		,SREP_NTC_FLG		= DECODE(@[srep_ntc_flg],'1','Y','N')" ).append("\n"); 
		query.append("		,OB_PIC_NTC_FLG		= DECODE(@[ob_pic_ntc_flg],'1','Y','N')" ).append("\n"); 
		query.append("		,CNTC_EML			= @[cntc_eml]" ).append("\n"); 
		query.append("		,CNTC_MPHN_NO		= @[cntc_mphn_no]" ).append("\n"); 
		query.append("		,CTRT_OFC_PHN_NO	= @[ctrt_ofc_phn_no]" ).append("\n"); 
		query.append("		,AUTO_NTC_FLG		= DECODE(@[auto_ntc_flg],'1','Y','N')" ).append("\n"); 
		query.append("		,UPD_USR_ID			= @[upd_usr_id]" ).append("\n"); 
		query.append("		,UPD_DT				= SYSDATE" ).append("\n"); 
		query.append("WHERE	POL_CD				= @[pol_cd]" ).append("\n"); 
		query.append("AND		LANE_CD				= @[lane_cd]" ).append("\n"); 
		query.append("AND     DIR_CD				= @[dir_cd]" ).append("\n"); 

	}
}