/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOsearchVerifyTariffFileListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.12.15 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOsearchVerifyTariffFileListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회 - Tariff File Verify 후 조회
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOsearchVerifyTariffFileListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration ").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOsearchVerifyTariffFileListDataRSQL").append("\n"); 
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
		query.append("SELECT A.TMP_SEQ," ).append("\n"); 
		query.append("A.TMP_DTL_SEQ," ).append("\n"); 
		query.append("A.INP_MSG1," ).append("\n"); 
		query.append("A.INP_MSG2," ).append("\n"); 
		query.append("A.INP_MSG4," ).append("\n"); 
		query.append("B.MNR_CD_DP_DESC AS INP_MSG5," ).append("\n"); 
		query.append("A.INP_MSG6," ).append("\n"); 
		query.append("A.INP_MSG7," ).append("\n"); 
		query.append("A.INP_MSG8," ).append("\n"); 
		query.append("A.INP_MSG9," ).append("\n"); 
		query.append("A.INP_MSG10," ).append("\n"); 
		query.append("A.INP_MSG11," ).append("\n"); 
		query.append("A.INP_MSG12," ).append("\n"); 
		query.append("A.INP_MSG13," ).append("\n"); 
		query.append("A.INP_MSG14," ).append("\n"); 
		query.append("A.INP_MSG15," ).append("\n"); 
		query.append("A.INP_MSG16," ).append("\n"); 
		query.append("A.INP_MSG17," ).append("\n"); 
		query.append("'NEW' INP_MSG18," ).append("\n"); 
		query.append("A.INP_MSG19," ).append("\n"); 
		query.append("A.INP_MSG20," ).append("\n"); 
		query.append("DECODE(A.INP_MSG4,'SS',1,0) AS CHECKBOX," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT MAX(D.EQ_CMPO_NM)" ).append("\n"); 
		query.append("FROM MNR_EQ_CMPO_CD C, MNR_EQ_CMPO_CD D" ).append("\n"); 
		query.append("WHERE C.EQ_CMPO_GRP_TP_CD = 3" ).append("\n"); 
		query.append("AND   D.EQ_CMPO_GRP_TP_CD = 2" ).append("\n"); 
		query.append("AND   C.EQ_PRNT_CMPO_CD = D.EQ_CMPO_CD" ).append("\n"); 
		query.append("AND   C.EQ_CMPO_CD = A.INP_MSG1" ).append("\n"); 
		query.append("GROUP BY C.EQ_CMPO_CD" ).append("\n"); 
		query.append(") INP_MSG23" ).append("\n"); 
		query.append("FROM MNR_DAT_VRFY A," ).append("\n"); 
		query.append("(SELECT MNR_CD_ID, MNR_CD_DP_DESC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD" ).append("\n"); 
		query.append("WHERE PRNT_CD_ID = 'CD00004') B" ).append("\n"); 
		query.append("WHERE A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND A.INP_MSG4 = B.MNR_CD_ID(+)" ).append("\n"); 
		query.append("ORDER BY A.TMP_SEQ, A.TMP_DTL_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}