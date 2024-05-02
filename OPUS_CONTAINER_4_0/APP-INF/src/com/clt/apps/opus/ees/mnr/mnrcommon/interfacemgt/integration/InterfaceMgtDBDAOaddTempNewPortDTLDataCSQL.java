/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceMgtDBDAOaddTempNewPortDTLDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOaddTempNewPortDTLDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addTempNewPortDTLData
	  * </pre>
	  */
	public InterfaceMgtDBDAOaddTempNewPortDTLDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rslt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ord_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_dtl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_rcv_ord_inv_tmp_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_rcv_ord_inv_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOaddTempNewPortDTLDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_ORD_TMP_DTL(" ).append("\n"); 
		query.append("        MNR_RCV_ORD_INV_TMP_SEQ, " ).append("\n"); 
		query.append("        MNR_RCV_ORD_INV_TMP_DTL_SEQ," ).append("\n"); 
		query.append("        ORD_DTL_SEQ, " ).append("\n"); 
		query.append("        COST_CD, " ).append("\n"); 
		query.append("        COST_DTL_CD," ).append("\n"); 
		query.append("        EQ_NO, " ).append("\n"); 
		query.append("        EQ_KND_CD, " ).append("\n"); 
		query.append("		EQ_TPSZ_CD," ).append("\n"); 
		query.append("        EQ_STS_CD, " ).append("\n"); 
		query.append("        RQST_REF_NO, " ).append("\n"); 
		query.append("        RPR_QTY, " ).append("\n"); 
		query.append("        YD_CD, " ).append("\n"); 
		query.append("        RPR_RSLT_DT, " ).append("\n"); 
		query.append("        VNDR_SEQ, " ).append("\n"); 
		query.append("        CURR_CD, " ).append("\n"); 
		query.append("        INV_AMT, " ).append("\n"); 
		query.append("        VRFY_RSLT_DESC,  " ).append("\n"); 
		query.append("        CRE_USR_ID, " ).append("\n"); 
		query.append("        CRE_DT, " ).append("\n"); 
		query.append("        UPD_USR_ID, " ).append("\n"); 
		query.append("        UPD_DT," ).append("\n"); 
		query.append("        VSL_CD," ).append("\n"); 
		query.append("        SKD_VOY_NO," ).append("\n"); 
		query.append("        PORT_CD," ).append("\n"); 
		query.append("        SLAN_CD " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("            @[mnr_rcv_ord_inv_tmp_seq]" ).append("\n"); 
		query.append("           ,@[mnr_rcv_ord_inv_tmp_dtl_seq]" ).append("\n"); 
		query.append("           ,@[ord_dtl_seq]" ).append("\n"); 
		query.append("           ,@[cost_cd]" ).append("\n"); 
		query.append("           ,@[cost_dtl_cd]" ).append("\n"); 
		query.append("           ,@[eq_no]" ).append("\n"); 
		query.append("		   ,(SELECT EQ_TYPE FROM MNR_EQ_STS_V WHERE EQ_NO = @[eq_no])" ).append("\n"); 
		query.append("           ,@[eq_tpsz_cd]" ).append("\n"); 
		query.append("           ,@[eq_sts_cd]" ).append("\n"); 
		query.append("           ,@[rqst_ref_no]" ).append("\n"); 
		query.append("           ,@[rpr_qty]" ).append("\n"); 
		query.append("           ,@[yd_cd]" ).append("\n"); 
		query.append("           ,TO_DATE(@[rpr_rslt_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("           ,@[vndr_seq]" ).append("\n"); 
		query.append("           ,@[curr_cd]" ).append("\n"); 
		query.append("           ,@[inv_amt]" ).append("\n"); 
		query.append("           ,'UN'" ).append("\n"); 
		query.append("           ,@[cre_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("           ,@[upd_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("           ,@[vsl_cd]" ).append("\n"); 
		query.append("           ,@[skd_voy_no]" ).append("\n"); 
		query.append("           ,@[port_cd]" ).append("\n"); 
		query.append("           ,@[slan_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}