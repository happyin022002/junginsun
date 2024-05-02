/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOModifyReportTemplateBstVipList2USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.22
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.12.22 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOModifyReportTemplateBstVipList2USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Report Template User Set Modify
	  * </pre>
	  */
	public PerformanceReportDBDAOModifyReportTemplateBstVipList2USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rpt_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vis_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOModifyReportTemplateBstVipList2USQL").append("\n"); 
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
		query.append("UPDATE BKG_RPT_SET" ).append("\n"); 
		query.append("SET    SC_NO          = @[sc_no]" ).append("\n"); 
		query.append(", BKG_CUST_TP_CD = NVL(@[bkg_cust_tp_cd],' ')" ).append("\n"); 
		query.append(", CUST_CNT_CD    = @[cust_cnt_cd]" ).append("\n"); 
		query.append(", CUST_SEQ       = @[cust_seq]" ).append("\n"); 
		query.append(", VIS_FLG        = DECODE(@[vis_flg],'1','Y','N')" ).append("\n"); 
		query.append(", UPD_USR_ID     = @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT         = SYSDATE" ).append("\n"); 
		query.append("WHERE BKG_RPT_KND_CD  = @[bkg_rpt_knd_cd]" ).append("\n"); 
		query.append("AND   RPT_ID          = @[rpt_id]" ).append("\n"); 
		query.append("AND   USR_ID          = @[upd_usr_id]" ).append("\n"); 

	}
}