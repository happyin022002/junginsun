/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BRKGAuditDBDAOModifyBRKGCommInfoAgtCmpnCommUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.27
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.04.27 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BRKGAuditDBDAOModifyBRKGCommInfoAgtCmpnCommUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyBRKGCommInfoAgtCmpnComm
	  * </pre>
	  */
	public BRKGAuditDBDAOModifyBRKGCommInfoAgtCmpnCommUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_fwrd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_fwrd_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("cmpn_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmpn_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.integration").append("\n"); 
		query.append("FileName : BRKGAuditDBDAOModifyBRKGCommInfoAgtCmpnCommUSQL").append("\n"); 
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
		query.append("UPDATE AGT_CMPN_COMM" ).append("\n"); 
		query.append("SET FRT_FWRD_CNT_CD   = @[frt_fwrd_cnt_cd]," ).append("\n"); 
		query.append("FRT_FWRD_SEQ      = @[frt_fwrd_seq]," ).append("\n"); 
		query.append("VNDR_CNT_CD       = @[vndr_cnt_cd]," ).append("\n"); 
		query.append("VNDR_SEQ          = @[vndr_seq]," ).append("\n"); 
		query.append("CMPN_REF_NO       = @[cmpn_ref_no]," ).append("\n"); 
		query.append("UPD_USR_ID        = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("WHERE BKG_NO            = @[bkg_no]" ).append("\n"); 
		query.append("AND CMPN_SEQ          = @[cmpn_seq]" ).append("\n"); 
		query.append("AND COMM_PROC_STS_CD != 'IF'" ).append("\n"); 

	}
}