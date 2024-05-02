/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOScgNonDgCgoKwRqstMailFormatRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOScgNonDgCgoKwRqstMailFormatRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OwnDangerousCargoApprovalDBDAOScgNonDgCgoKwRqstMailFormat
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOScgNonDgCgoKwRqstMailFormatRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("non_dcgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOScgNonDgCgoKwRqstMailFormatRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("   --'special-cargo@hanjin.com' AS FROM_PSN" ).append("\n"); 
		query.append("   (SELECT USR_EML FROM COM_USER WHERE USR_ID =  @[upd_usr_id] ) AS FROM_PSN" ).append("\n"); 
		query.append(" , (SELECT USR_EML FROM COM_USER WHERE USR_ID = B.DOC_USR_ID) AS TO_PSN" ).append("\n"); 
		query.append(" , 'special-cargo@hanjin.com' AS CC_PSN" ).append("\n"); 
		query.append(" , DECODE(A.NON_DG_CHEM_FLG,'Y','//Non-DG Chemical//')||'(CHECK) Booking number '||A.BKG_NO||', ,'||(SELECT TO_CHAR(D.VPS_ETA_DT,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("                                                FROM VSK_VSL_PORT_SKD D" ).append("\n"); 
		query.append("                                                WHERE 1=1" ).append("\n"); 
		query.append("                                                AND D.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                                                AND D.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                AND D.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                AND D.VPS_PORT_CD = B.POL_CD" ).append("\n"); 
		query.append("                                                AND D.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("                                             ) AS SUBJECT" ).append("\n"); 
		query.append(" , '' ATTACH_FILE" ).append("\n"); 
		query.append(" , '' BODY_HEADER" ).append("\n"); 
		query.append(" , '' BODY_FOOTER" ).append("\n"); 
		query.append(" , DECODE(A.NON_DG_CHEM_FLG,'Y','FM:VESSEL OPERATION TEAM <p>Good day,<p>Pls upload documents for Non-DG chemical in ALPS.<p>Thank you. ', 'FM:VESSEL OPERATION TEAM <p>Good day,<p>We need more information on this commodity before loading.<p>Could you please send us cargo photos or other information, like loading history & MSDS if have,<p>for our easy understanding<p>Thank you.' )  AS BODY_CONTS" ).append("\n"); 
		query.append("FROM SCG_NON_DG_CGO_KW_RQST A" ).append("\n"); 
		query.append("     , BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE	A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	A.NON_DCGO_RQST_SEQ = @[non_dcgo_rqst_seq]" ).append("\n"); 
		query.append("AND A.BKG_NO = B.BKG_NO" ).append("\n"); 

	}
}