/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFARateQuotationDBDAORsltPriSurchargeAdjustCommodityDetailVORSQL.java
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

public class RFARateQuotationDBDAORsltPriSurchargeAdjustCommodityDetailVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    Surcharge Adjust Commodity를 검색할때 group 또는 commodity 상세정보를 보여준다.
	  * </pre>
	  */
	public RFARateQuotationDBDAORsltPriSurchargeAdjustCommodityDetailVORSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_cmdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration").append("\n"); 
		query.append("FileName : RFARateQuotationDBDAORsltPriSurchargeAdjustCommodityDetailVORSQL").append("\n"); 
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
		query.append("SELECT cmdt_mdm.cmdt_cd as  cmdt_def_cd , cmdt_mdm.cmdt_nm as cmdt_nm" ).append("\n"); 
		query.append("FROM  pri_rq_grp_cmdt_dtl cmdt_dtl" ).append("\n"); 
		query.append(", mdm_commodity cmdt_mdm" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("cmdt_dtl.qttn_no = @[qttn_no]" ).append("\n"); 
		query.append("AND cmdt_dtl.qttn_ver_no = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND cmdt_dtl.grp_cmdt_seq = @[grp_cmdt_seq]" ).append("\n"); 
		query.append("AND cmdt_dtl.prc_cmdt_def_cd = cmdt_mdm.cmdt_cd" ).append("\n"); 
		query.append("AND 'G' = @[cmdt_tp_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  cmdt_mdm.cmdt_cd as  cmdt_def_cd , cmdt_mdm.cmdt_nm as cmdt_nm" ).append("\n"); 
		query.append("FROM mdm_commodity cmdt_mdm" ).append("\n"); 
		query.append("WHERE 	cmdt_mdm.cmdt_cd = @[cmdt_def_cd]" ).append("\n"); 
		query.append("AND 'C' = @[cmdt_tp_cd]" ).append("\n"); 
		query.append("ORDER BY cmdt_def_cd" ).append("\n"); 

	}
}