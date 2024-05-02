/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOInsertEACRegistrationN3rdPtyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.05 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOInsertEACRegistrationN3rdPtyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eas_expn_aud_cs_n3rd_pty 에 저장
	  * </pre>
	  */
	public EacMgtDBDAOInsertEACRegistrationN3rdPtyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cust_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpb_vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpb_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("audr_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_expn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOInsertEACRegistrationN3rdPtyCSQL").append("\n"); 
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
		query.append("INSERT INTO EAS_EXPN_AUD_CS_N3RD_PTY(" ).append("\n"); 
		query.append("                                     EAC_NO" ).append("\n"); 
		query.append("                                   , N3PTY_EXPN_TP_CD" ).append("\n"); 
		query.append("                                   , N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("                                   , BKG_NO" ).append("\n"); 
		query.append("                                   , BL_NO" ).append("\n"); 
		query.append("                                   , VNDR_CUST_DIV_CD" ).append("\n"); 
		query.append("                                   , VNDR_CNT_CD" ).append("\n"); 
		query.append("                                   , VNDR_SEQ" ).append("\n"); 
		query.append("                                   , CUST_CNT_CD" ).append("\n"); 
		query.append("                                   , CUST_SEQ" ).append("\n"); 
		query.append("                                   , N3PTY_OFC_CD" ).append("\n"); 
		query.append("                                   , N3PTY_IF_DT " ).append("\n"); 
		query.append("                                   , CRE_USR_ID" ).append("\n"); 
		query.append("                                   , CRE_DT" ).append("\n"); 
		query.append("                                   , UPD_USR_ID" ).append("\n"); 
		query.append("                                   , UPD_DT" ).append("\n"); 
		query.append("                                   )VALUES(" ).append("\n"); 
		query.append("                                     @[eac_no]" ).append("\n"); 
		query.append("                                   , @[n3pty_expn_tp_cd]" ).append("\n"); 
		query.append("                                   , @[n3pty_bil_tp_cd]" ).append("\n"); 
		query.append("                                   , @[bkg_no]" ).append("\n"); 
		query.append("                                   , @[bl_no]" ).append("\n"); 
		query.append("                                   , @[vndr_cust_div_cd]" ).append("\n"); 
		query.append("                                   , @[tpb_vndr_cnt_cd]" ).append("\n"); 
		query.append("                                   , @[tpb_vndr_seq]" ).append("\n"); 
		query.append("                                   , @[cust_cnt_cd]" ).append("\n"); 
		query.append("                                   , @[cust_seq]" ).append("\n"); 
		query.append("                                   , @[n3pty_ofc_cd]" ).append("\n"); 
		query.append("                                   , SYSDATE" ).append("\n"); 
		query.append("                                   , @[audr_usr_id]" ).append("\n"); 
		query.append("                                   , SYSDATE" ).append("\n"); 
		query.append("                                   , @[audr_usr_id]" ).append("\n"); 
		query.append("                                   , SYSDATE" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}