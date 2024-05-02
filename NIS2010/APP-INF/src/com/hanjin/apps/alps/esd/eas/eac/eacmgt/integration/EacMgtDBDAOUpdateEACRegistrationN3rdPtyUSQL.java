/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOUpdateEACRegistrationN3rdPtyUSQL.java
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

public class EacMgtDBDAOUpdateEACRegistrationN3rdPtyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eas_expn_aud_cs_n3rd_pty 수정
	  * </pre>
	  */
	public EacMgtDBDAOUpdateEACRegistrationN3rdPtyUSQL(){
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
		query.append("FileName : EacMgtDBDAOUpdateEACRegistrationN3rdPtyUSQL").append("\n"); 
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
		query.append("UPDATE EAS_EXPN_AUD_CS_N3RD_PTY" ).append("\n"); 
		query.append("SET    EAC_NO           = @[eac_no]" ).append("\n"); 
		query.append("     , N3PTY_EXPN_TP_CD = @[n3pty_expn_tp_cd]" ).append("\n"); 
		query.append("     , N3PTY_BIL_TP_CD  = @[n3pty_bil_tp_cd]" ).append("\n"); 
		query.append("     , BKG_NO           = @[bkg_no]" ).append("\n"); 
		query.append("     , BL_NO            = @[bl_no]" ).append("\n"); 
		query.append("     , VNDR_CUST_DIV_CD = @[vndr_cust_div_cd]" ).append("\n"); 
		query.append("     , VNDR_CNT_CD      = @[tpb_vndr_cnt_cd]" ).append("\n"); 
		query.append("     , VNDR_SEQ         = @[tpb_vndr_seq]" ).append("\n"); 
		query.append("     , CUST_CNT_CD      = @[cust_cnt_cd]" ).append("\n"); 
		query.append("     , CUST_SEQ         = @[cust_seq]" ).append("\n"); 
		query.append("     , N3PTY_OFC_CD     = @[n3pty_ofc_cd]" ).append("\n"); 
		query.append("     , UPD_USR_ID       = @[audr_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT           = SYSDATE" ).append("\n"); 
		query.append("WHERE EAC_NO            = @[eac_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}