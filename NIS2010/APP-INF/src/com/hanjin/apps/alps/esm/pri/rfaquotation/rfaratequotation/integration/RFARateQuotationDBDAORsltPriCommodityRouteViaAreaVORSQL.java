/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFARateQuotationDBDAORsltPriCommodityRouteViaAreaVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.04 송민석
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

public class RFARateQuotationDBDAORsltPriCommodityRouteViaAreaVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public RFARateQuotationDBDAORsltPriCommodityRouteViaAreaVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_loc_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_via_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_via_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_loc_def_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : RFARateQuotationDBDAORsltPriCommodityRouteViaAreaVORSQL").append("\n"); 
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
		query.append("SELECT DISTINCT ROUT_VIA_PORT_DEF_CD AS CD , ROUT_VIA_PORT_DEF_CD AS NM" ).append("\n"); 
		query.append("FROM PRI_RQ_RT_ROUT_VIA MN" ).append("\n"); 
		query.append("WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ori_loc_def_cd} != '')" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("SELECT 'FOUND'" ).append("\n"); 
		query.append("FROM PRI_RQ_RT_ROUT_PNT SUB" ).append("\n"); 
		query.append("WHERE 	    SUB.QTTN_NO = MN.QTTN_NO" ).append("\n"); 
		query.append("AND SUB.QTTN_VER_NO = MN.QTTN_VER_NO" ).append("\n"); 
		query.append("AND SUB.CMDT_HDR_SEQ = MN.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND SUB.ROUT_SEQ = MN.ROUT_SEQ" ).append("\n"); 
		query.append("AND SUB.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("AND SUB.ROUT_PNT_LOC_DEF_CD =@[ori_loc_def_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${dest_loc_def_cd} != '')" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("SELECT 'FOUND'" ).append("\n"); 
		query.append("FROM PRI_RQ_RT_ROUT_PNT SUB" ).append("\n"); 
		query.append("WHERE 	    SUB.QTTN_NO = MN.QTTN_NO" ).append("\n"); 
		query.append("AND SUB.QTTN_VER_NO = MN.QTTN_VER_NO" ).append("\n"); 
		query.append("AND SUB.CMDT_HDR_SEQ = MN.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND SUB.ROUT_SEQ = MN.ROUT_SEQ" ).append("\n"); 
		query.append("AND SUB.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("AND SUB.ROUT_PNT_LOC_DEF_CD = @[dest_loc_def_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${ori_via_def_cd} != '')" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("SELECT 'FOUND'" ).append("\n"); 
		query.append("FROM PRI_RQ_RT_ROUT_VIA SUB" ).append("\n"); 
		query.append("WHERE 	    SUB.QTTN_NO = MN.QTTN_NO" ).append("\n"); 
		query.append("AND SUB.QTTN_VER_NO = MN.QTTN_VER_NO" ).append("\n"); 
		query.append("AND SUB.CMDT_HDR_SEQ = MN.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND SUB.ROUT_SEQ = MN.ROUT_SEQ" ).append("\n"); 
		query.append("AND SUB.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("AND SUB.ROUT_VIA_PORT_DEF_CD = @[ori_via_def_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${dest_via_def_cd} != '')" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("SELECT 'FOUND'" ).append("\n"); 
		query.append("FROM PRI_RQ_RT_ROUT_VIA SUB" ).append("\n"); 
		query.append("WHERE 	    SUB.QTTN_NO = MN.QTTN_NO" ).append("\n"); 
		query.append("AND SUB.QTTN_VER_NO = MN.QTTN_VER_NO" ).append("\n"); 
		query.append("AND SUB.CMDT_HDR_SEQ = MN.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND SUB.ROUT_SEQ = MN.ROUT_SEQ" ).append("\n"); 
		query.append("AND SUB.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("AND SUB.ROUT_VIA_PORT_DEF_CD = @[dest_via_def_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}