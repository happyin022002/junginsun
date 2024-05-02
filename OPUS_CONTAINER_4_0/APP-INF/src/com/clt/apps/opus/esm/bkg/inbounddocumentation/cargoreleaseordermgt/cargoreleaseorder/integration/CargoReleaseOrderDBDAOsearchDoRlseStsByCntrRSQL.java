/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchDoRlseStsByCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchDoRlseStsByCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchDoRlseStsByCntrRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchDoRlseStsByCntrRSQL").append("\n"); 
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
		query.append("SELECT SUBQ.BKG_NO                               AS BKG_NO" ).append("\n"); 
		query.append(", SUBQ.RLSE_SEQ                             AS RLSE_SEQ" ).append("\n"); 
		query.append(", SUBQ.RLSE_STS_SEQ                         AS RLSE_STS_SEQ" ).append("\n"); 
		query.append(", SUBQ.CNTR_NO                              AS CNTR_NO" ).append("\n"); 
		query.append(", DOTL.RLSE_STS_CD                          AS RLSE_STS_CD" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02152' AND INTG_CD_VAL_CTNT = DOTL.RLSE_STS_CD) AS RLSE_STS_NM" ).append("\n"); 
		query.append(", DECODE(BKDO.DO_NO_SPLIT, '00', BKDO.DO_NO, BKDO.DO_NO || BKDO.DO_NO_SPLIT) AS DO_NO" ).append("\n"); 
		query.append(", TO_CHAR(DOTL.EVNT_DT,'YYYYMMDD HH24:MI', 'NLS_DATE_LANGUAGE=ENGLISH') EVNT_DT" ).append("\n"); 
		query.append(", DOTL.EVNT_USR_ID                          AS EVNT_USR_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT BCNT.BKG_NO       AS BKG_NO" ).append("\n"); 
		query.append(", BCNT.CNTR_NO      AS CNTR_NO" ).append("\n"); 
		query.append(", DCNT.RLSE_SEQ     AS RLSE_SEQ" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (PARTITION BY BCNT.BKG_NO,BCNT.CNTR_NO ORDER BY DCNT.RLSE_SEQ DESC) RLSE_RNUM" ).append("\n"); 
		query.append(", (SELECT /*+ INDEX_DESC (DOTL XPKBKG_DO_DTL) */" ).append("\n"); 
		query.append("IDTL.RLSE_STS_SEQ" ).append("\n"); 
		query.append("FROM BKG_DO_DTL IDTL" ).append("\n"); 
		query.append("WHERE IDTL.BKG_NO = DCNT.BKG_NO" ).append("\n"); 
		query.append("AND IDTL.RLSE_SEQ = DCNT.RLSE_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1 ) RLSE_STS_SEQ" ).append("\n"); 
		query.append("FROM BKG_CONTAINER BCNT" ).append("\n"); 
		query.append(", BKG_DO_CNTR   DCNT" ).append("\n"); 
		query.append("WHERE BCNT.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BCNT.BKG_NO   = DCNT.BKG_NO(+)" ).append("\n"); 
		query.append("AND BCNT.CNTR_NO  = DCNT.CNTR_NO(+)" ).append("\n"); 
		query.append(") SUBQ" ).append("\n"); 
		query.append(", BKG_DO BKDO" ).append("\n"); 
		query.append(", BKG_DO_DTL DOTL" ).append("\n"); 
		query.append(", BKG_ARR_NTC_CNTR ACNTR" ).append("\n"); 
		query.append("WHERE SUBQ.RLSE_RNUM = 1" ).append("\n"); 
		query.append("AND BKDO.BKG_NO(+)       = SUBQ.BKG_NO" ).append("\n"); 
		query.append("AND BKDO.RLSE_SEQ(+)     = SUBQ.RLSE_SEQ" ).append("\n"); 
		query.append("AND DOTL.BKG_NO(+)       = SUBQ.BKG_NO" ).append("\n"); 
		query.append("AND DOTL.RLSE_SEQ(+)     = SUBQ.RLSE_SEQ" ).append("\n"); 
		query.append("AND DOTL.RLSE_STS_SEQ(+) = SUBQ.RLSE_STS_SEQ" ).append("\n"); 
		query.append("AND ACNTR.BKG_NO(+)      = SUBQ.BKG_NO" ).append("\n"); 

	}
}