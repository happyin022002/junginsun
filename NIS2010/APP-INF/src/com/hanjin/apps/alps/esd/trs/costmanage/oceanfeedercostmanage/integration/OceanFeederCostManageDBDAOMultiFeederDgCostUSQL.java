/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OceanFeederCostManageDBDAOMultiFeederDgCostUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanFeederCostManageDBDAOMultiFeederDgCostUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.07.04 변종건 [CHM-201217633] Ocean Feeder Cost Management 수정 및 신규 탭 추가
	  * </pre>
	  */
	public OceanFeederCostManageDBDAOMultiFeederDgCostUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_n3rd_clss_svc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_n2nd_clss_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_n9th_clss_svc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_n3rd_clss_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_n4th_clss_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_n5th_clss_svc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_n7th_clss_svc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_n1st_clss_svc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_n4th_clss_svc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_n8th_clss_svc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_trf_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_n6th_clss_svc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_n1st_clss_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_n7th_clss_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_n6th_clss_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_n2nd_clss_svc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_n5th_clss_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_n8th_clss_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_n9th_clss_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.integration ").append("\n"); 
		query.append("FileName : OceanFeederCostManageDBDAOMultiFeederDgCostUSQL").append("\n"); 
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
		query.append("UPDATE  TRS_FDR_DG_COST_TRF" ).append("\n"); 
		query.append("SET     IMDG_N1ST_CLSS_SVC_FLG  = @[imdg_n1st_clss_svc_flg]" ).append("\n"); 
		query.append(", IMDG_N1ST_CLSS_SCG_AMT  = @[imdg_n1st_clss_scg_amt]" ).append("\n"); 
		query.append(", IMDG_N2ND_CLSS_SVC_FLG  = @[imdg_n2nd_clss_svc_flg]" ).append("\n"); 
		query.append(", IMDG_N2ND_CLSS_SCG_AMT  = @[imdg_n2nd_clss_scg_amt]" ).append("\n"); 
		query.append(", IMDG_N3RD_CLSS_SVC_FLG  = @[imdg_n3rd_clss_svc_flg]" ).append("\n"); 
		query.append(", IMDG_N3RD_CLSS_SCG_AMT  = @[imdg_n3rd_clss_scg_amt]" ).append("\n"); 
		query.append(", IMDG_N4TH_CLSS_SVC_FLG  = @[imdg_n4th_clss_svc_flg]" ).append("\n"); 
		query.append(", IMDG_N4TH_CLSS_SCG_AMT  = @[imdg_n4th_clss_scg_amt]" ).append("\n"); 
		query.append(", IMDG_N5TH_CLSS_SVC_FLG  = @[imdg_n5th_clss_svc_flg]" ).append("\n"); 
		query.append(", IMDG_N5TH_CLSS_SCG_AMT  = @[imdg_n5th_clss_scg_amt]" ).append("\n"); 
		query.append(", IMDG_N6TH_CLSS_SVC_FLG  = @[imdg_n6th_clss_svc_flg]" ).append("\n"); 
		query.append(", IMDG_N6TH_CLSS_SCG_AMT  = @[imdg_n6th_clss_scg_amt]" ).append("\n"); 
		query.append(", IMDG_N7TH_CLSS_SVC_FLG  = @[imdg_n7th_clss_svc_flg]" ).append("\n"); 
		query.append(", IMDG_N7TH_CLSS_SCG_AMT  = @[imdg_n7th_clss_scg_amt]" ).append("\n"); 
		query.append(", IMDG_N8TH_CLSS_SVC_FLG  = @[imdg_n8th_clss_svc_flg]" ).append("\n"); 
		query.append(", IMDG_N8TH_CLSS_SCG_AMT  = @[imdg_n8th_clss_scg_amt]" ).append("\n"); 
		query.append(", IMDG_N9TH_CLSS_SVC_FLG  = @[imdg_n9th_clss_svc_flg]" ).append("\n"); 
		query.append(", IMDG_N9TH_CLSS_SCG_AMT  = @[imdg_n9th_clss_scg_amt]" ).append("\n"); 
		query.append(", UPD_USR_ID              = @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT                  = SYSDATE" ).append("\n"); 
		query.append("WHERE   COST_TRF_NO             = @[cost_trf_no]" ).append("\n"); 
		query.append("AND     COST_TRF_ROUT_SEQ       = @[cost_trf_rout_seq]" ).append("\n"); 

	}
}