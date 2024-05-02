/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterStandardPrimeCostDAOFmsMktRtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.07.08 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi,Woo-Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterStandardPrimeCostDAOFmsMktRtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Hire Base Input Insert
	  * </pre>
	  */
	public TCharterStandardPrimeCostDAOFmsMktRtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rng_to_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bld_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mkt_rt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rng_fm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mkt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.integration").append("\n"); 
		query.append("FileName : TCharterStandardPrimeCostDAOFmsMktRtCSQL").append("\n"); 
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
		query.append("insert into fms_mkt_rt (" ).append("\n"); 
		query.append("mkt_rt_yrmon," ).append("\n"); 
		query.append("mkt_rt_seq," ).append("\n"); 
		query.append("rng_fm_qty," ).append("\n"); 
		query.append("rng_to_qty," ).append("\n"); 
		query.append("bld_tp_nm," ).append("\n"); 
		query.append("mkt_rt_amt," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("cre_usr_id" ).append("\n"); 
		query.append(") values(" ).append("\n"); 
		query.append("@[mkt_rt_yrmon]," ).append("\n"); 
		query.append("FMS_MKT_RT_MKT_RT_SEQ.nextval," ).append("\n"); 
		query.append("@[rng_fm_qty]," ).append("\n"); 
		query.append("@[rng_to_qty]," ).append("\n"); 
		query.append("@[bld_tp_nm]," ).append("\n"); 
		query.append("@[mkt_rt_amt]," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("@[cre_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}