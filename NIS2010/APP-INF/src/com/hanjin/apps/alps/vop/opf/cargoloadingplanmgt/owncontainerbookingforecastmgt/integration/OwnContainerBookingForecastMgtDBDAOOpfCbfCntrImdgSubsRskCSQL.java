/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOOpfCbfCntrImdgSubsRskCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.13
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2010.04.13 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOOpfCbfCntrImdgSubsRskCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OpfCbfCntrImdgSubsRsk 입력
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOOpfCbfCntrImdgSubsRskCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_shpr_ownr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cbf_smry_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOOpfCbfCntrImdgSubsRskCSQL").append("\n"); 
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
		query.append("INSERT INTO OPF_CBF_CNTR_IMDG_SUBS_RSK(" ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("BKG_SHPR_OWNR_FLG," ).append("\n"); 
		query.append("CRR_CD," ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("CBF_SMRY_SEQ," ).append("\n"); 
		query.append("IMDG_SUBS_RSK_LBL_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[vsl_cd]," ).append("\n"); 
		query.append("@[skd_voy_no]," ).append("\n"); 
		query.append("@[skd_dir_cd]," ).append("\n"); 
		query.append("@[bkg_shpr_ownr_flg]," ).append("\n"); 
		query.append("@[crr_cd]," ).append("\n"); 
		query.append("@[yd_cd]," ).append("\n"); 
		query.append("@[pol_clpt_ind_seq]," ).append("\n"); 
		query.append("@[cbf_smry_seq]," ).append("\n"); 
		query.append("Z.SPLITVAL," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("TO_DATE(REPLACE(REPLACE(@[cre_dt],'-',''),':',''),'YYYYMMDD HH24MISS')," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("TO_DATE(REPLACE(REPLACE(@[cre_dt],'-',''),':',''),'YYYYMMDD HH24MISS')" ).append("\n"); 
		query.append("FROM DUAL X," ).append("\n"); 
		query.append("(SELECT SUBSTR ('/' || DECODE(@[imdg_subs_rsk_lbl_cd],'+','',@[imdg_subs_rsk_lbl_cd]) || '/'," ).append("\n"); 
		query.append("INSTR ('/' || DECODE(@[imdg_subs_rsk_lbl_cd],'+','',@[imdg_subs_rsk_lbl_cd]) || '/', '/', 1, B.RN) + 1," ).append("\n"); 
		query.append("INSTR ('/' || DECODE(@[imdg_subs_rsk_lbl_cd],'+','',@[imdg_subs_rsk_lbl_cd]) || '/', '/', 1, B.RN + 1)" ).append("\n"); 
		query.append("- INSTR ('/' || DECODE(@[imdg_subs_rsk_lbl_cd],'+','',@[imdg_subs_rsk_lbl_cd]) || '/', '/', 1, B.RN)" ).append("\n"); 
		query.append("- 1" ).append("\n"); 
		query.append(") SPLITVAL" ).append("\n"); 
		query.append("FROM (SELECT ROWNUM RN" ).append("\n"); 
		query.append("FROM DICT) B" ).append("\n"); 
		query.append("WHERE LENGTH ('/' || DECODE(@[imdg_subs_rsk_lbl_cd],'+','',@[imdg_subs_rsk_lbl_cd]) || '/')" ).append("\n"); 
		query.append("- LENGTH (REPLACE ('/' || DECODE(@[imdg_subs_rsk_lbl_cd],'+','',@[imdg_subs_rsk_lbl_cd]) || '/', '/', ''))" ).append("\n"); 
		query.append("- 1 >= B.RN) Z" ).append("\n"); 

	}
}