/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFARateQuotationDBDAORsltPriSurchargeAdjustCommodityVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.04 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateQuotationDBDAORsltPriSurchargeAdjustCommodityVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    Surcharge Adjust Commodity를 검색할때 group 또는 commodity Master를 보여준다.
	  * </pre>
	  */
	public RFARateQuotationDBDAORsltPriSurchargeAdjustCommodityVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration").append("\n"); 
		query.append("FileName : RFARateQuotationDBDAORsltPriSurchargeAdjustCommodityVORSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("WITH dstct_rt_cmdt AS (" ).append("\n"); 
		query.append("SELECT DISTINCT rt_cmdt.prc_cmdt_def_cd" ).append("\n"); 
		query.append(", rt_cmdt.qttn_no,rt_cmdt.qttn_ver_no, rt_cmdt.prc_cmdt_tp_cd" ).append("\n"); 
		query.append("FROM pri_rq_rt_cmdt rt_cmdt" ).append("\n"); 
		query.append("WHERE rt_cmdt.qttn_no = @[qttn_no]" ).append("\n"); 
		query.append("AND rt_cmdt.qttn_ver_no = @[qttn_ver_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT rt_cmdt.prc_cmdt_def_cd as  prc_cmdt_def_cd , grp_cmdt.prc_grp_cmdt_desc as prc_grp_cmdt_desc" ).append("\n"); 
		query.append(", grp_cmdt.qttn_no,grp_cmdt.qttn_ver_no,grp_cmdt.grp_cmdt_seq, rt_cmdt.prc_cmdt_tp_cd" ).append("\n"); 
		query.append("FROM dstct_rt_cmdt rt_cmdt" ).append("\n"); 
		query.append(", pri_rq_grp_cmdt grp_cmdt" ).append("\n"); 
		query.append("WHERE rt_cmdt.prc_cmdt_tp_cd = 'G'" ).append("\n"); 
		query.append("AND rt_cmdt.qttn_no = grp_cmdt.qttn_no" ).append("\n"); 
		query.append("AND rt_cmdt.qttn_ver_no = grp_cmdt.qttn_ver_no" ).append("\n"); 
		query.append("AND rt_cmdt.prc_cmdt_def_cd = grp_cmdt.prc_grp_cmdt_cd" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT mdm_cmdt.cmdt_cd  , mdm_cmdt.cmdt_nm as prc_grp_cmdt_desc" ).append("\n"); 
		query.append(", rt_cmdt.qttn_no,rt_cmdt.qttn_ver_no,0,rt_cmdt.prc_cmdt_tp_cd" ).append("\n"); 
		query.append("FROM dstct_rt_cmdt rt_cmdt" ).append("\n"); 
		query.append(", mdm_commodity mdm_cmdt" ).append("\n"); 
		query.append("WHERE rt_cmdt.prc_cmdt_tp_cd = 'C'" ).append("\n"); 
		query.append("AND mdm_cmdt.delt_flg = 'N'" ).append("\n"); 
		query.append("AND rt_cmdt.prc_cmdt_def_cd = mdm_cmdt.cmdt_cd" ).append("\n"); 
		query.append("ORDER BY prc_cmdt_tp_cd DESC,prc_cmdt_def_cd" ).append("\n"); 

	}
}