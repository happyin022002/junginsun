/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchExchangeCNTRRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.09.08 김성일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungil Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchExchangeCNTRRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchExchangeCNTR
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchExchangeCNTRRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_chg_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("IN_ORG_YD_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("P_ACT_RCV_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("IN_MVMT_STS_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchExchangeCNTRRSQL").append("\n"); 
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
		query.append("select a.cop_no  v_cop_no" ).append("\n"); 
		query.append(",a.cop_dtl_seq v_cop_dtl_seq" ).append("\n"); 
		query.append(",a.nod_cd v_cop_nod_cd" ).append("\n"); 
		query.append(",a.act_sts_cd v_cop_act_sts_cd" ).append("\n"); 
		query.append(",b.act_rcv_tp_cd v_act_rcv_tp_cd" ).append("\n"); 
		query.append(",b.act_sts_mapg_cd v_cop_act_sts_mapg_cd" ).append("\n"); 
		query.append(",a.vsl_cd v_vsl_cd" ).append("\n"); 
		query.append(",a.skd_voy_no v_skd_voy_no" ).append("\n"); 
		query.append(",a.skd_dir_cd v_skd_dir_cd" ).append("\n"); 
		query.append(",a.stnd_edi_sts_cd v_act_stnd_edi_sts_cd" ).append("\n"); 
		query.append(",a.act_sts_cd v_act_sts_cd" ).append("\n"); 
		query.append("from   sce_cop_dtl  a, sce_act_act_mapg b" ).append("\n"); 
		query.append("where  a.cop_no          = @[v_chg_cop_no]" ).append("\n"); 
		query.append("and    a.nod_cd          = @[IN_ORG_YD_CD]" ).append("\n"); 
		query.append("and    a.act_cd          = b.act_cd" ).append("\n"); 
		query.append("and    b.act_rcv_tp_cd   = @[P_ACT_RCV_TP_CD]" ).append("\n"); 
		query.append("and    b.act_sts_mapg_cd = @[IN_MVMT_STS_CD]" ).append("\n"); 

	}
}