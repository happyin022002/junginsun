/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOmodifyMGSOnhireEquipmentDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2015.01.08 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOmodifyMGSOnhireEquipmentDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOmodifyMGSOnhireEquipmentDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgst_mchn_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgst_vltg_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agreement_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgst_fuel_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mft_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_spec_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOmodifyMGSOnhireEquipmentDataUSQL").append("\n"); 
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
		query.append("-- EQUIPMENT TABLE UPDATE" ).append("\n"); 
		query.append("UPDATE CGM_EQUIPMENT" ).append("\n"); 
		query.append("   SET ONH_OFC_CD       = @[onh_ofc_cd]," ).append("\n"); 
		query.append("       ONH_DT           = TO_DATE(@[onh_dt],'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("       CHSS_MVMT_DT     = TO_DATE(@[onh_dt],'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("       MFT_DT           = TO_DATE(@[mft_dt],'YYYY-MM-DD')," ).append("\n"); 
		query.append("	   ONH_YD_CD        = @[onh_yd_cd]," ).append("\n"); 
		query.append("       CRNT_YD_CD       = @[onh_yd_cd]," ).append("\n"); 
		query.append("       EQ_SPEC_NO       = @[eq_spec_no]," ).append("\n"); 
		query.append("       MGST_MCHN_SER_NO = @[mgst_mchn_ser_no]," ).append("\n"); 
		query.append("       MGST_VLTG_CAPA   = @[mgst_vltg_capa]," ).append("\n"); 
		query.append("       MGST_FUEL_CAPA   = @[mgst_fuel_capa]," ).append("\n"); 
		query.append("       EQ_STS_SEQ       = NVL(CGM_GET_EQ_STS_HIS_MAXSEQ_FNC(@[eq_no]) ,0)," ).append("\n"); 
		query.append("       CRNT_LOC_CD      = SUBSTR(@[onh_yd_cd],0,5)," ).append("\n"); 
		query.append("       ACIAC_DIV_CD     = 'A'," ).append("\n"); 
		query.append("       EQ_KND_CD        = @[eq_knd_cd]," ).append("\n"); 
		query.append("       VNDR_SEQ         = @[vndr_seq]," ).append("\n"); 
		query.append("       AGMT_OFC_CTY_CD  = SUBSTR(@[agreement_no],0,3)," ).append("\n"); 
		query.append("       AGMT_SEQ         = SUBSTR(@[agreement_no],4,12)," ).append("\n"); 
		query.append("       AGMT_VER_NO      = @[agmt_ver_no]," ).append("\n"); 
		query.append("       EQ_TPSZ_CD       = @[eq_tpsz_cd]," ).append("\n"); 
		query.append("       UPD_USR_ID       = @[upd_usr_id]," ).append("\n"); 
		query.append("	   AGMT_LSTM_CD     = @[agmt_lstm_cd]," ).append("\n"); 
		query.append("       UPD_DT           = SYSDATE" ).append("\n"); 
		query.append(" WHERE EQ_NO =@[eq_no]" ).append("\n"); 

	}
}