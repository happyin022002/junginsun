/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOsearchApprovalListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOsearchApprovalListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SELECT APPROVAL NO
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOsearchApprovalListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOsearchApprovalListDataRSQL").append("\n"); 
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
		query.append("SELECT   AA.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("       , AA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       , DECODE(AA.NEW_VAN_TP_CD, 'O', 'OLD', 'NEW') NEW_VAN_TP_CD" ).append("\n"); 
		query.append("       , TO_CHAR(AA.ONH_QTY, '9,999,999,999,999,999') AS ONH_QTY" ).append("\n"); 
		query.append("       , TO_CHAR(AA.PICK_QTY, '9,999,999,999,999,999') AS PICK_QTY" ).append("\n"); 
		query.append("       , AA.PKUP_DUE_DT" ).append("\n"); 
		query.append("       , AA.MIN_ONH_DYS" ).append("\n"); 
		query.append("       , AA.PKUP_CHG_AMT" ).append("\n"); 
		query.append("       , AA.PKUP_CHG_CR_AMT" ).append("\n"); 
		query.append("       , AA.LIFT_ON_CHG" ).append("\n"); 
		query.append("       , AA.FREE_DYS" ).append("\n"); 
		query.append("       , TO_CHAR(AA.ONH_QTY - AA.PICK_QTY, '9,999,999,999,999,999') AS BALANCE" ).append("\n"); 
		query.append("       , AA.LOC_CD DOL" ).append("\n"); 
		query.append("       , AA.ECC_CD ECC" ).append("\n"); 
		query.append("       , DECODE(AA.NEW_VAN_TP_CD, 'N', '', (" ).append("\n"); 
		query.append("                                             SELECT   ONH_QTY" ).append("\n"); 
		query.append("                                             FROM     LSE_ONH_APRO_QTY A" ).append("\n"); 
		query.append("                                             WHERE    1 = 1" ).append("\n"); 
		query.append("                                             AND      A.CNTR_ONH_AUTH_NO = AA.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("                                             AND      A.CNTR_TPSZ_CD = AA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                             AND      A.NEW_VAN_TP_CD = 'L'" ).append("\n"); 
		query.append("                                           )" ).append("\n"); 
		query.append("         ) LON_CHG" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   A.CNTR_SPEC_NO" ).append("\n"); 
		query.append("           FROM     LSE_AGMT_RT A" ).append("\n"); 
		query.append("                  , MST_CNTR_SPEC B" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("           AND      A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("           AND      A.LOC_CD = 'KRSEL'" ).append("\n"); 
		query.append("           AND      A.CNTR_TPSZ_CD = AA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("           AND      A.CNTR_RNTL_CHG_TP_CD = 'GENV'" ).append("\n"); 
		query.append("           AND      A.CNTR_SPEC_NO = B.CNTR_SPEC_NO" ).append("\n"); 
		query.append("         ) CNTR_SPEC_NO" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("           SELECT   B.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("                  , B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  , B.NEW_VAN_TP_CD" ).append("\n"); 
		query.append("                  , B.ONH_QTY" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   COUNT(DISTINCT D.CNTR_NO)" ).append("\n"); 
		query.append("                      FROM     MST_CONTAINER C" ).append("\n"); 
		query.append("                             , MST_CNTR_STS_HIS D" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      C.AGMT_CTY_CD = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                      AND      C.AGMT_SEQ = A.AGMT_SEQ" ).append("\n"); 
		query.append("                      AND      C.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      AND      C.CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("                      AND      C.CNTR_AUTH_NO = A.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("#if (${gubun} != '1')" ).append("\n"); 
		query.append("                      AND      D.CNTR_OLD_VAN_FLG = DECODE(B.NEW_VAN_TP_CD, 'O', 'Y', 'N')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                      AND      D.CNTR_OLD_VAN_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                      AND      D.CNTR_STS_CD = 'LSI'" ).append("\n"); 
		query.append("                    ) PICK_QTY" ).append("\n"); 
		query.append("                  , TO_CHAR(A.PKUP_DUE_DT, 'YYYY-MM-DD') PKUP_DUE_DT" ).append("\n"); 
		query.append("                  , A.MIN_ONH_DYS" ).append("\n"); 
		query.append("                  , A.PKUP_CHG_AMT" ).append("\n"); 
		query.append("                  , A.PKUP_CHG_CR_AMT" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   LFT_CHG_AMT" ).append("\n"); 
		query.append("                      FROM     LSE_ONH_APRO_QTY" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      CNTR_ONH_AUTH_NO = B.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("                      AND      AGMT_CTY_CD = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                      AND      AGMT_SEQ = A.AGMT_SEQ" ).append("\n"); 
		query.append("                      AND      CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      AND      NEW_VAN_TP_CD = 'O'" ).append("\n"); 
		query.append("                    ) LIFT_ON_CHG" ).append("\n"); 
		query.append("                  , A.FREE_DYS" ).append("\n"); 
		query.append("                  , A.LOC_CD" ).append("\n"); 
		query.append("                  , A.ECC_CD" ).append("\n"); 
		query.append("           FROM     LSE_ONH_APRO A" ).append("\n"); 
		query.append("                  , LSE_ONH_APRO_QTY B" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("           AND      A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("           AND      A.ONH_LOC_CD =" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                      SELECT   O.LCC_CD" ).append("\n"); 
		query.append("                      FROM     MDM_LOCATION B" ).append("\n"); 
		query.append("                             , MDM_EQ_ORZ_CHT O" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      B.LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5)" ).append("\n"); 
		query.append("                      AND      B.SCC_CD = O.SCC_CD" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("           AND      A.PKUP_DUE_DT >= TRUNC(GLOBALDATE_PKG.TIME_LOCAL_FNC(A.ONH_LOC_CD))" ).append("\n"); 
		query.append("           AND      A.CNTR_ONH_AUTH_NO = B.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("           AND      A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("           AND      A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("#if (${gubun} == '1')" ).append("\n"); 
		query.append("           AND      B.NEW_VAN_TP_CD = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           AND      B.NEW_VAN_TP_CD IN ( 'O','N' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND      B.ONH_QTY > 0" ).append("\n"); 
		query.append("         ) AA" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      AA.ONH_QTY > AA.PICK_QTY" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}