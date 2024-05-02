/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOSearchVerifyTpbIfRSQL.java
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

public class EacMgtDBDAOSearchVerifyTpbIfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * I/F 전에 중복 여부를 체크한다
	  * </pre>
	  */
	public EacMgtDBDAOSearchVerifyTpbIfRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("eac_expn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOSearchVerifyTpbIfRSQL").append("\n"); 
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
		query.append("SELECT 'TPB No : '||WM_CONCAT(DISTINCT N3PTY_NO) N3PTY_NO, COUNT(*) CNT" ).append("\n"); 
		query.append("  FROM TPB_OTS_DTL A" ).append("\n"); 
		query.append(" WHERE N3PTY_SRC_SUB_SYS_CD IN ('TES', 'TRS') -- 하드코딩" ).append("\n"); 
		query.append("   AND N3PTY_SRC_SUB_SYS_CD = @[eac_expn_tp_cd] -- EAS_EXPN_AUD_CS_MGMT.EAC_EXPN_TP_CD " ).append("\n"); 
		query.append("   AND SRC_VNDR_SEQ = @[vndr_seq]    -- EAS_EXPN_AUD_CS_MGMT.VNDR_SEQ" ).append("\n"); 
		query.append("   AND N3PTY_SRC_NO = @[n3pty_src_no]  -- EAS_EXPN_AUD_CS_MGMT.N3PTY_SRC_NO" ).append("\n"); 
		query.append("   AND BKG_NO = @[bkg_no]  -- EAS_EXPN_AUD_CS_N3RD_PTY.BKG_NO" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'TPB No : '||WM_CONCAT(DISTINCT N3PTY_NO) N3PTY_NO, COUNT(*) CNT" ).append("\n"); 
		query.append("  FROM TPB_OTS_DTL A" ).append("\n"); 
		query.append(" WHERE N3PTY_SRC_SUB_SYS_CD IN ('PSO', 'MNR') -- 하드코딩" ).append("\n"); 
		query.append("   AND N3PTY_SRC_SUB_SYS_CD = @[eac_expn_tp_cd] -- EAS_EXPN_AUD_CS_MGMT.EAC_EXPN_TP_CD " ).append("\n"); 
		query.append("   AND SRC_VNDR_SEQ = @[vndr_seq]       -- VNDR_SEQ  EAS_EXPN_AUD_CS_MGMT.VNDR_SEQ" ).append("\n"); 
		query.append("   AND N3PTY_SRC_NO = @[n3pty_src_no] -- INV_NO    EAS_EXPN_AUD_CS_MGMT.N3PTY_SRC_NO" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}