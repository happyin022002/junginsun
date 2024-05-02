/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommRequestDBDAOExecuteRateDetalInputListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.26
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.07.26 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOExecuteRateDetalInputListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AGNCommRequestDBDAOExecuteRateDetalInputListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOExecuteRateDetalInputListUSQL").append("\n"); 
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
		query.append("UPDATE ACM_AGN_COMM_DTL U" ).append("\n"); 
		query.append("       SET" ).append("\n"); 
		query.append("         ( U.IF_DTRB_AMT," ).append("\n"); 
		query.append("           U.PAY_IF_DTRB_AMT, " ).append("\n"); 
		query.append("           U.UPD_USR_ID," ).append("\n"); 
		query.append("           U.UPD_DT" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("         =" ).append("\n"); 
		query.append("         (     " ).append("\n"); 
		query.append("     SELECT" ).append("\n"); 
		query.append("                    CASE B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    WHEN 'D2'" ).append("\n"); 
		query.append("                    THEN                  " ).append("\n"); 
		query.append("                        ROUND" ).append("\n"); 
		query.append("                        ( B.BKG_VOL_QTY * 0.5 / " ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                                NVL((" ).append("\n"); 
		query.append("                                SELECT BKG_VOL_QTY" ).append("\n"); 
		query.append("                                  FROM ACM_AGN_COMM_DTL X" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND X.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("                                   AND X.AGN_CD         = B.AGN_CD" ).append("\n"); 
		query.append("                                   AND X.AC_TP_CD       = B.AC_TP_CD" ).append("\n"); 
		query.append("                                   AND X.IO_BND_CD      = B.IO_BND_CD" ).append("\n"); 
		query.append("                                   AND X.AC_SEQ         = B.AC_SEQ" ).append("\n"); 
		query.append("                                   AND X.CNTR_TPSZ_CD   = 'D4'" ).append("\n"); 
		query.append("                                ),0)" ).append("\n"); 
		query.append("                                +" ).append("\n"); 
		query.append("                                NVL((" ).append("\n"); 
		query.append("                                SELECT BKG_VOL_QTY" ).append("\n"); 
		query.append("                                  FROM ACM_AGN_COMM_DTL X" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND X.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("                                   AND X.AGN_CD         = B.AGN_CD" ).append("\n"); 
		query.append("                                   AND X.AC_TP_CD       = B.AC_TP_CD" ).append("\n"); 
		query.append("                                   AND X.IO_BND_CD      = B.IO_BND_CD" ).append("\n"); 
		query.append("                                   AND X.AC_SEQ         = B.AC_SEQ" ).append("\n"); 
		query.append("                                   AND X.CNTR_TPSZ_CD   = 'D5'" ).append("\n"); 
		query.append("                                ),0)" ).append("\n"); 
		query.append("                                 + B.BKG_VOL_QTY * 0.5 " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                            * A.IF_AMT, " ).append("\n"); 
		query.append("                            2" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                    WHEN 'D4'" ).append("\n"); 
		query.append("                    THEN " ).append("\n"); 
		query.append("                        ROUND" ).append("\n"); 
		query.append("                        ( B.BKG_VOL_QTY  / " ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                                B.BKG_VOL_QTY" ).append("\n"); 
		query.append("                                +" ).append("\n"); 
		query.append("                                NVL((" ).append("\n"); 
		query.append("                                SELECT BKG_VOL_QTY" ).append("\n"); 
		query.append("                                  FROM ACM_AGN_COMM_DTL X" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND X.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("                                   AND X.AGN_CD         = B.AGN_CD" ).append("\n"); 
		query.append("                                   AND X.AC_TP_CD       = B.AC_TP_CD" ).append("\n"); 
		query.append("                                   AND X.IO_BND_CD      = B.IO_BND_CD" ).append("\n"); 
		query.append("                                   AND X.AC_SEQ         = B.AC_SEQ" ).append("\n"); 
		query.append("                                   AND X.CNTR_TPSZ_CD   = 'D5'" ).append("\n"); 
		query.append("                                ),0)" ).append("\n"); 
		query.append("                                +                                 " ).append("\n"); 
		query.append("                                NVL((" ).append("\n"); 
		query.append("                                SELECT BKG_VOL_QTY" ).append("\n"); 
		query.append("                                  FROM ACM_AGN_COMM_DTL X" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND X.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("                                   AND X.AGN_CD         = B.AGN_CD" ).append("\n"); 
		query.append("                                   AND X.AC_TP_CD       = B.AC_TP_CD" ).append("\n"); 
		query.append("                                   AND X.IO_BND_CD      = B.IO_BND_CD" ).append("\n"); 
		query.append("                                   AND X.AC_SEQ         = B.AC_SEQ" ).append("\n"); 
		query.append("                                   AND X.CNTR_TPSZ_CD   = 'D2'" ).append("\n"); 
		query.append("                                ),0) * 0.5 " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                            * A.IF_AMT, " ).append("\n"); 
		query.append("                            2" ).append("\n"); 
		query.append("                         )                         " ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                        ROUND" ).append("\n"); 
		query.append("                        ( B.BKG_VOL_QTY  / " ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                                B.BKG_VOL_QTY" ).append("\n"); 
		query.append("                                +" ).append("\n"); 
		query.append("                                NVL((" ).append("\n"); 
		query.append("                                SELECT BKG_VOL_QTY" ).append("\n"); 
		query.append("                                  FROM ACM_AGN_COMM_DTL X" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND X.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("                                   AND X.AGN_CD         = B.AGN_CD" ).append("\n"); 
		query.append("                                   AND X.AC_TP_CD       = B.AC_TP_CD" ).append("\n"); 
		query.append("                                   AND X.IO_BND_CD      = B.IO_BND_CD" ).append("\n"); 
		query.append("                                   AND X.AC_SEQ         = B.AC_SEQ" ).append("\n"); 
		query.append("                                   AND X.CNTR_TPSZ_CD   = 'D4'" ).append("\n"); 
		query.append("                                ),0)                                " ).append("\n"); 
		query.append("                                + " ).append("\n"); 
		query.append("                                NVL((" ).append("\n"); 
		query.append("                                SELECT BKG_VOL_QTY" ).append("\n"); 
		query.append("                                  FROM ACM_AGN_COMM_DTL X" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND X.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("                                   AND X.AGN_CD         = B.AGN_CD" ).append("\n"); 
		query.append("                                   AND X.AC_TP_CD       = B.AC_TP_CD" ).append("\n"); 
		query.append("                                   AND X.IO_BND_CD      = B.IO_BND_CD" ).append("\n"); 
		query.append("                                   AND X.AC_SEQ         = B.AC_SEQ" ).append("\n"); 
		query.append("                                   AND X.CNTR_TPSZ_CD   = 'D2'" ).append("\n"); 
		query.append("                                ),0) * 0.5 " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                            * A.IF_AMT, " ).append("\n"); 
		query.append("                            2" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                    END   " ).append("\n"); 
		query.append("                                                                AS IF_DTRB_AMT," ).append("\n"); 
		query.append("                 CASE A.CURR_CD" ).append("\n"); 
		query.append("                 WHEN 'USD'" ).append("\n"); 
		query.append("                 THEN B.IF_DTRB_AMT" ).append("\n"); 
		query.append("                 ELSE " ).append("\n"); 
		query.append("                    CASE B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    WHEN 'D2'" ).append("\n"); 
		query.append("                    THEN                  " ).append("\n"); 
		query.append("                        ROUND" ).append("\n"); 
		query.append("                        ( B.BKG_VOL_QTY * 0.5 / " ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                                NVL((" ).append("\n"); 
		query.append("                                SELECT BKG_VOL_QTY" ).append("\n"); 
		query.append("                                  FROM ACM_AGN_COMM_DTL X" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND X.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("                                   AND X.AGN_CD         = B.AGN_CD" ).append("\n"); 
		query.append("                                   AND X.AC_TP_CD       = B.AC_TP_CD" ).append("\n"); 
		query.append("                                   AND X.IO_BND_CD      = B.IO_BND_CD" ).append("\n"); 
		query.append("                                   AND X.AC_SEQ         = B.AC_SEQ" ).append("\n"); 
		query.append("                                   AND X.CNTR_TPSZ_CD   = 'D4'" ).append("\n"); 
		query.append("                                ),0) " ).append("\n"); 
		query.append("                                +" ).append("\n"); 
		query.append("                                NVL((" ).append("\n"); 
		query.append("                                SELECT BKG_VOL_QTY" ).append("\n"); 
		query.append("                                  FROM ACM_AGN_COMM_DTL X" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND X.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("                                   AND X.AGN_CD         = B.AGN_CD" ).append("\n"); 
		query.append("                                   AND X.AC_TP_CD       = B.AC_TP_CD" ).append("\n"); 
		query.append("                                   AND X.IO_BND_CD      = B.IO_BND_CD" ).append("\n"); 
		query.append("                                   AND X.AC_SEQ         = B.AC_SEQ" ).append("\n"); 
		query.append("                                   AND X.CNTR_TPSZ_CD   = 'D5'" ).append("\n"); 
		query.append("                                ),0)                                " ).append("\n"); 
		query.append("                                + B.BKG_VOL_QTY * 0.5 " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                            * A.PAY_IF_AMT, " ).append("\n"); 
		query.append("                            2" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                    WHEN 'D4'" ).append("\n"); 
		query.append("                    THEN" ).append("\n"); 
		query.append("                        ROUND" ).append("\n"); 
		query.append("                        ( B.BKG_VOL_QTY  / " ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                                B.BKG_VOL_QTY" ).append("\n"); 
		query.append("                                +" ).append("\n"); 
		query.append("                                NVL((" ).append("\n"); 
		query.append("                                SELECT BKG_VOL_QTY" ).append("\n"); 
		query.append("                                  FROM ACM_AGN_COMM_DTL X" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND X.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("                                   AND X.AGN_CD         = B.AGN_CD" ).append("\n"); 
		query.append("                                   AND X.AC_TP_CD       = B.AC_TP_CD" ).append("\n"); 
		query.append("                                   AND X.IO_BND_CD      = B.IO_BND_CD" ).append("\n"); 
		query.append("                                   AND X.AC_SEQ         = B.AC_SEQ" ).append("\n"); 
		query.append("                                   AND X.CNTR_TPSZ_CD   = 'D5'" ).append("\n"); 
		query.append("                                ),0)" ).append("\n"); 
		query.append("                                +                                 " ).append("\n"); 
		query.append("                                NVL((" ).append("\n"); 
		query.append("                                SELECT BKG_VOL_QTY" ).append("\n"); 
		query.append("                                  FROM ACM_AGN_COMM_DTL X" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND X.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("                                   AND X.AGN_CD         = B.AGN_CD" ).append("\n"); 
		query.append("                                   AND X.AC_TP_CD       = B.AC_TP_CD" ).append("\n"); 
		query.append("                                   AND X.IO_BND_CD      = B.IO_BND_CD" ).append("\n"); 
		query.append("                                   AND X.AC_SEQ         = B.AC_SEQ" ).append("\n"); 
		query.append("                                   AND X.CNTR_TPSZ_CD   = 'D2'" ).append("\n"); 
		query.append("                                ),0) * 0.5 " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                            * A.PAY_IF_AMT, " ).append("\n"); 
		query.append("                            2" ).append("\n"); 
		query.append("                         )                         " ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                        ROUND" ).append("\n"); 
		query.append("                        ( B.BKG_VOL_QTY  / " ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                                B.BKG_VOL_QTY" ).append("\n"); 
		query.append("                                +" ).append("\n"); 
		query.append("                                NVL((" ).append("\n"); 
		query.append("                                SELECT BKG_VOL_QTY" ).append("\n"); 
		query.append("                                  FROM ACM_AGN_COMM_DTL X" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND X.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("                                   AND X.AGN_CD         = B.AGN_CD" ).append("\n"); 
		query.append("                                   AND X.AC_TP_CD       = B.AC_TP_CD" ).append("\n"); 
		query.append("                                   AND X.IO_BND_CD      = B.IO_BND_CD" ).append("\n"); 
		query.append("                                   AND X.AC_SEQ         = B.AC_SEQ" ).append("\n"); 
		query.append("                                   AND X.CNTR_TPSZ_CD   = 'D4'" ).append("\n"); 
		query.append("                                ),0)" ).append("\n"); 
		query.append("                                +                                 " ).append("\n"); 
		query.append("                                NVL((" ).append("\n"); 
		query.append("                                SELECT BKG_VOL_QTY" ).append("\n"); 
		query.append("                                  FROM ACM_AGN_COMM_DTL X" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND X.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("                                   AND X.AGN_CD         = B.AGN_CD" ).append("\n"); 
		query.append("                                   AND X.AC_TP_CD       = B.AC_TP_CD" ).append("\n"); 
		query.append("                                   AND X.IO_BND_CD      = B.IO_BND_CD" ).append("\n"); 
		query.append("                                   AND X.AC_SEQ         = B.AC_SEQ" ).append("\n"); 
		query.append("                                   AND X.CNTR_TPSZ_CD   = 'D2'" ).append("\n"); 
		query.append("                                ),0) * 0.5 " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                            * A.PAY_IF_AMT, " ).append("\n"); 
		query.append("                            2" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                    END   " ).append("\n"); 
		query.append("                  END                                             AS PAY_IF_AMT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      @[usr_id]                                   AS UPD_USR_ID," ).append("\n"); 
		query.append("                      SYSDATE                                     AS UPD_DT" ).append("\n"); 
		query.append("                 FROM ACM_AGN_COMM     A," ).append("\n"); 
		query.append("                      ACM_AGN_COMM_DTL B" ).append("\n"); 
		query.append("                WHERE A.BKG_NO         = U.BKG_NO" ).append("\n"); 
		query.append("                  AND A.AGN_CD         = U.AGN_CD" ).append("\n"); 
		query.append("                  AND A.AC_TP_CD      <> 'T'" ).append("\n"); 
		query.append("                  AND A.IO_BND_CD      = U.IO_BND_CD" ).append("\n"); 
		query.append("                  AND A.AC_SEQ         = U.AC_SEQ" ).append("\n"); 
		query.append("--                  AND A.CRE_USR_ID    != 'COST'" ).append("\n"); 
		query.append("                  AND A.AC_TP_CD       = U.AC_TP_CD" ).append("\n"); 
		query.append("                  AND B.CNTR_TPSZ_CD   = U.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  AND A.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("                  AND A.AGN_CD         = B.AGN_CD" ).append("\n"); 
		query.append("                  AND A.AC_TP_CD       = B.AC_TP_CD" ).append("\n"); 
		query.append("                  AND A.IO_BND_CD      = B.IO_BND_CD" ).append("\n"); 
		query.append("                  AND A.AC_SEQ         = B.AC_SEQ" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("     WHERE U.BKG_NO         = @[bkg_no]" ).append("\n"); 
		query.append("       AND U.AGN_CD         = @[agn_cd]" ).append("\n"); 
		query.append("       AND U.AC_TP_CD      <> 'T'" ).append("\n"); 
		query.append("       AND U.IO_BND_CD      = @[io_bnd_cd]" ).append("\n"); 
		query.append("       AND U.AC_SEQ         = @[ac_seq]" ).append("\n"); 
		query.append("--       AND U.CRE_USR_ID    != 'COST''										" ).append("\n"); 

	}
}