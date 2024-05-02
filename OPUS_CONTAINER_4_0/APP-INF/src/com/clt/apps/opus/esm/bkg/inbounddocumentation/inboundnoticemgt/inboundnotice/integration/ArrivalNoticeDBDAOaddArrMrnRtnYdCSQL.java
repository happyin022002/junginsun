/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ArrivalNoticeDBDAOaddArrMrnRtnYdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOaddArrMrnRtnYdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public ArrivalNoticeDBDAOaddArrMrnRtnYdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOaddArrMrnRtnYdCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_ARR_NTC_CNTR(bkg_no," ).append("\n"); 
		query.append("		 cntr_no," ).append("\n"); 
		query.append("		 rtn_yd_cd," ).append("\n"); 
		query.append("		 mvmt_ref_no," ).append("\n"); 
		query.append("		 MTY_RTN_YD_NM," ).append("\n"); 
		query.append("		 cre_usr_id," ).append("\n"); 
		query.append("		 cre_dt," ).append("\n"); 
		query.append("		 upd_usr_id," ).append("\n"); 
		query.append("		 upd_dt" ).append("\n"); 
		query.append("		 )" ).append("\n"); 
		query.append("		VALUES" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		 (select bkg_no from bkg_booking where bl_no = @[bl_no])," ).append("\n"); 
		query.append("		 @[cntr_no]," ).append("\n"); 
		query.append("		 @[mty_rtn_yd_cd]," ).append("\n"); 
		query.append("		 @[vsl_mrn_no]," ).append("\n"); 
		query.append("		 @[rtn_ref_no]," ).append("\n"); 
		query.append("		 @[cre_usr_id]," ).append("\n"); 
		query.append("		 sysdate," ).append("\n"); 
		query.append("		 @[upd_usr_id]," ).append("\n"); 
		query.append("		 sysdate" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}