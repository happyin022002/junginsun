/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EQFlagMgtDBDAOsearchEQDataForDisposalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOsearchEQDataForDisposalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화면: EES_MNR_0151(Disposal Candidate Selection)
	  * 위치: Equipment Management > M&R > Disposal > Planning > Disposal Candidate Selection
	  * 
	  * Load Excel 시, 해당하는 EQ Data를 조회하여 온다.(단, Disposal Candidate 유무는 상관없이 모두 조회함.)
	  * 
	  * * Load Excel의 기능: 다 건의 EQ에 대하여 한꺼번에 Disposal Candidate Flag 컨트롤을 하기 위하여 생성((CHM-201642026)
	  * </pre>
	  */
	public EQFlagMgtDBDAOsearchEQDataForDisposalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOsearchEQDataForDisposalRSQL").append("\n"); 
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
		query.append("SELECT DECODE(A.MNR_DISP_SEL_FLG, 'Y', '1', '0') AS MNR_DISP_SEL_FLG ," ).append("\n"); 
		query.append("       'C' AS DISP_RSN_CD," ).append("\n"); 
		query.append("       B.EQ_NO AS EQ_NO," ).append("\n"); 
		query.append("       B.EQ_TPSZ_CD AS EQ_TPSZ_CD," ).append("\n"); 
		query.append("       B.LSTM_CD AS LSTM_CD," ).append("\n"); 
		query.append("       (SELECT C.DISP_NO" ).append("\n"); 
		query.append("          FROM MNR_DISP_DTL C" ).append("\n"); 
		query.append("         WHERE C.EQ_NO=A.EQ_NO" ).append("\n"); 
		query.append("           AND C.EQ_TPSZ_CD=A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("           AND C.DISP_YD_CD=A.MNR_DISP_SEL_FLG_YD_CD" ).append("\n"); 
		query.append("           AND ROWNUM=1) AS DISP_NO ," ).append("\n"); 
		query.append("       (SELECT F.MNR_CD_DP_DESC" ).append("\n"); 
		query.append("          FROM MNR_DISP_DTL C ," ).append("\n"); 
		query.append("               MNR_DISP_HDR D," ).append("\n"); 
		query.append("               MNR_GEN_CD F" ).append("\n"); 
		query.append("         WHERE C.DISP_NO=D.DISP_NO" ).append("\n"); 
		query.append("           AND C.EQ_NO=A.EQ_NO" ).append("\n"); 
		query.append("           AND C.EQ_TPSZ_CD=A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("           AND C.DISP_YD_CD=A.MNR_DISP_SEL_FLG_YD_CD" ).append("\n"); 
		query.append("           AND F.PRNT_CD_ID='CD00029'" ).append("\n"); 
		query.append("           AND D.DISP_STS_CD=F.MNR_CD_ID" ).append("\n"); 
		query.append("           AND ROWNUM=1) AS DISP_STS_NM," ).append("\n"); 
		query.append("       DECODE(A.MNR_DISP_SEL_FLG, 'Y', NVL(A.MNR_DISP_SEL_FLG_YD_CD, B.CRNT_YD_CD), B.CRNT_YD_CD) AS MNR_DISP_SEL_FLG_YD_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') AS UPD_DT," ).append("\n"); 
		query.append("       A.UPD_USR_ID AS UPD_USR_ID," ).append("\n"); 
		query.append("       B.EQ_TYPE AS EQ_KND_CD" ).append("\n"); 
		query.append("  FROM MNR_EQ_STS A," ).append("\n"); 
		query.append("       MNR_EQ_STS_V B" ).append("\n"); 
		query.append(" WHERE B.EQ_NO = A.EQ_NO(+)" ).append("\n"); 
		query.append("#if (${eq_knd_cd} != '') " ).append("\n"); 
		query.append("   AND B.EQ_TYPE = @[eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND (1, B.EQ_NO) IN (" ).append("\n"); 
		query.append("#if ($eq_list.size() > 0 ) " ).append("\n"); 
		query.append("	#foreach( $key in ${eq_list}) " ).append("\n"); 
		query.append("    	#if($velocityCount < $eq_list.size())" ).append("\n"); 
		query.append("    		(1, '$key')," ).append("\n"); 
		query.append("    	#else " ).append("\n"); 
		query.append("    		(1, '$key')" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	(2, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}