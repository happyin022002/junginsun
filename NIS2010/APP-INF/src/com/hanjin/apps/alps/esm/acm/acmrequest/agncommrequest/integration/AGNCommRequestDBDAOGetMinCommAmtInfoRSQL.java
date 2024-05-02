/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : AGNCommRequestDBDAOGetMinCommAmtInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOGetMinCommAmtInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetMinCommAmtInfo
	  * </pre>
	  */
	public AGNCommRequestDBDAOGetMinCommAmtInfoRSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOGetMinCommAmtInfoRSQL").append("\n"); 
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
		query.append("WITH ACM_CNTR_TPSZ AS (" ).append("\n"); 
		query.append("     SELECT B.CNTR_TPSZ_GRP_NM," ).append("\n"); 
		query.append("                  B.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("             FROM (SELECT CNTR_TPSZ_GRP_NM," ).append("\n"); 
		query.append("                           (ACM_JOIN_FNC(CURSOR(SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                  FROM ACM_AGN_SET_CNTR_GRP" ).append("\n"); 
		query.append("                                                 WHERE CNTR_TPSZ_GRP_NM = A.CNTR_TPSZ_GRP_NM" ).append("\n"); 
		query.append("                                                 GROUP BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                 ORDER BY CNTR_TPSZ_CD),'|')) AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     FROM ACM_AGN_SET_CNTR_GRP A) B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             GROUP BY B.CNTR_TPSZ_GRP_NM," ).append("\n"); 
		query.append("                      B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             ORDER BY B.CNTR_TPSZ_GRP_NM," ).append("\n"); 
		query.append("                      B.CNTR_TPSZ_CD   " ).append("\n"); 
		query.append("    )," ).append("\n"); 
		query.append("    ACM_AGN_AGMT_MIN_COMM_PARAM AS (" ).append("\n"); 
		query.append("        SELECT  AGN_CD ," ).append("\n"); 
		query.append("                AGN_AGMT_NO," ).append("\n"); 
		query.append("                IO_BND_CD," ).append("\n"); 
		query.append("                AC_TP_CD," ).append("\n"); 
		query.append("                AGN_AGMT_SEQ," ).append("\n"); 
		query.append("                AGN_AGMT_MIN_COMM_SEQ," ).append("\n"); 
		query.append("                MIN_COMM_DIV_CD," ).append("\n"); 
		query.append("                MIN_COMM_RT," ).append("\n"); 
		query.append("                MIN_COMM_CURR_CD," ).append("\n"); 
		query.append("                MIN_COMM_PER_CD," ).append("\n"); 
		query.append("                MIN_COMM_NET_REV_AMT," ).append("\n"); 
		query.append("                MIN_COMM_NET_REV_CURR_CD," ).append("\n"); 
		query.append("                (SELECT NVL(CNTR_TPSZ_CD,'') FROM ACM_CNTR_TPSZ WHERE CNTR_TPSZ_GRP_NM = MIN_COMM_PER_CD) AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          FROM ACM_AGN_AGMT_MIN_COMM " ).append("\n"); 
		query.append("         WHERE AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("           AND AGN_AGMT_NO = @[agn_agmt_no]" ).append("\n"); 
		query.append("           AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("           AND AC_TP_CD = @[ac_tp_cd]" ).append("\n"); 
		query.append("           AND AGN_AGMT_SEQ = @[agn_agmt_seq]" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("      SELECT " ).append("\n"); 
		query.append("                SUM(CASE " ).append("\n"); 
		query.append("                    WHEN MIN_COMM_DIV_CD = 'N' THEN " ).append("\n"); 
		query.append("                        MIN_COMM_NET_REV_AMT * (MIN_COMM_RT/100)" ).append("\n"); 
		query.append("                    WHEN MIN_COMM_DIV_CD = 'F' THEN " ).append("\n"); 
		query.append("                        CASE " ).append("\n"); 
		query.append("                            WHEN MIN_COMM_PER_CD = 'B/L' THEN" ).append("\n"); 
		query.append("                                MIN_COMM_RT" ).append("\n"); 
		query.append("                            WHEN MIN_COMM_PER_CD = 'Box' THEN" ).append("\n"); 
		query.append("                                MIN_COMM_RT * (SELECT SUM(OP_CNTR_QTY) FROM BKG_QUANTITY WHERE BKG_NO = @[bkg_no]) " ).append("\n"); 
		query.append("                            WHEN MIN_COMM_PER_CD = '20' OR MIN_COMM_PER_CD = '40'  THEN" ).append("\n"); 
		query.append("                                (SELECT DECODE(COUNT(OP_CNTR_QTY), 0 , 0, MIN_COMM_RT * COUNT(OP_CNTR_QTY))   " ).append("\n"); 
		query.append("                                   FROM BKG_QUANTITY " ).append("\n"); 
		query.append("                                  WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                                    AND REGEXP_LIKE(CNTR_TPSZ_CD,PA.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("                END)  MIN_COMM_AMT" ).append("\n"); 
		query.append("      FROM ACM_AGN_AGMT_MIN_COMM_PARAM PA" ).append("\n"); 
		query.append("      GROUP BY MIN_COMM_DIV_CD" ).append("\n"); 

	}
}