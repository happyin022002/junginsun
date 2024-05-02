/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DailyForecastManageDBDAOSpcDlyFcastCustDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOSpcDlyFcastCustDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PC_DLY_FCAST_CUST의 지정된 ibflag 값에 따라 DB에 반영한다.(삭제)
	  * 2016.03.30 CTRT_NO 조건 추가
	  * </pre>
	  */
	public DailyForecastManageDBDAOSpcDlyFcastCustDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_ts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSpcDlyFcastCustDSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("  FROM SPC_DLY_FCAST_CUST " ).append("\n"); 
		query.append(" WHERE RLANE_CD         = @[rlane_cd]" ).append("\n"); 
		query.append("   AND DIR_CD           = @[dir_cd]" ).append("\n"); 
		query.append("   AND VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND IOC_TS_CD        = @[ioc_ts_cd]" ).append("\n"); 
		query.append("   AND SREP_USR_ID      = @[srep_usr_id]" ).append("\n"); 
		query.append("   AND CUST_CNT_CD      = NVL(@[cust_cnt_cd], '00')" ).append("\n"); 
		query.append("   AND CUST_SEQ         = NVL(@[cust_seq], 0)" ).append("\n"); 
		query.append("   AND POL_YD_CD        = NVL(@[pol_yd_cd], '0000000')" ).append("\n"); 
		query.append("   AND POD_YD_CD        = NVL(@[pod_yd_cd], '0000000')" ).append("\n"); 
		query.append("   AND FCAST_OFC_CD     = @[fcast_ofc_cd]" ).append("\n"); 
		query.append("   AND FCAST_CUST_TP_CD = NVL(@[fcast_cust_tp_cd], '0')" ).append("\n"); 
		query.append("   --20160204.ADD, 20160211.MOD" ).append("\n"); 
		query.append("   AND NVL(CTRT_CUST_CNT_CD, '00') = NVL(@[ctrt_cust_cnt_cd], '00')" ).append("\n"); 
		query.append("   AND NVL(CTRT_CUST_SEQ, 0)       = NVL(@[ctrt_cust_seq], 0)" ).append("\n"); 
		query.append("   AND NVL(CTRT_NO, '00') = NVL(@[ctrt_no], '00') --2016.03.30 ADD" ).append("\n"); 

	}
}