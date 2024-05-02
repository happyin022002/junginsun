/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchIBCopRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.14
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.10.14 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchIBCopRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 구주 지역은 BKG_EURO_TRO_DTL, 그 이외 지역은 BKG_TRO_DTL 을 참조하여 INBOUND 의 TRO 가 MAPPING 될 COP 정보를 조회한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchIBCopRSQL(){
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
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_sub_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchIBCopRSQL").append("\n"); 
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
		query.append("SELECT COP_NO," ).append("\n"); 
		query.append("ACT_STS_CD," ).append("\n"); 
		query.append("A.VSL_CD VSL_CD," ).append("\n"); 
		query.append("A.SKD_VOY_NO SKD_VOY_NO," ).append("\n"); 
		query.append("A.SKD_DIR_CD SKD_DIR_CD," ).append("\n"); 
		query.append("CLPT_IND_SEQ," ).append("\n"); 
		query.append("CNTR_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("D.COP_NO COP_NO," ).append("\n"); 
		query.append("D.ACT_STS_CD ACT_STS_CD ," ).append("\n"); 
		query.append("LAG(D.VSL_CD, 1) OVER (PARTITION BY D.COP_NO" ).append("\n"); 
		query.append("ORDER BY D.COP_NO, D.COP_DTL_SEQ) VSL_CD ," ).append("\n"); 
		query.append("LAG(D.SKD_VOY_NO, 1) OVER (PARTITION BY D.COP_NO" ).append("\n"); 
		query.append("ORDER BY D.COP_NO, D.COP_DTL_SEQ) SKD_VOY_NO ," ).append("\n"); 
		query.append("LAG(D.SKD_DIR_CD, 1) OVER (PARTITION BY D.COP_NO" ).append("\n"); 
		query.append("ORDER BY D.COP_NO, D.COP_DTL_SEQ) SKD_DIR_CD ," ).append("\n"); 
		query.append("D.ACT_CD ," ).append("\n"); 
		query.append("LAG(D.CLPT_IND_SEQ, 1) OVER (PARTITION BY D.COP_NO" ).append("\n"); 
		query.append("ORDER BY D.COP_NO, D.COP_DTL_SEQ) CLPT_IND_SEQ," ).append("\n"); 
		query.append("H.CNTR_NO" ).append("\n"); 
		query.append("FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("SCE_COP_DTL D," ).append("\n"); 
		query.append("#if (${area_conti_cd} == 'E')" ).append("\n"); 
		query.append("BKG_EUR_TRO TRO_HDR,  -- 구주" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${area_conti_cd} == 'X')" ).append("\n"); 
		query.append("BKG_TRO_DTL TRO_DTL -- 구주가 아닐경우" ).append("\n"); 
		query.append("#elseif (${area_conti_cd} == 'E')" ).append("\n"); 
		query.append("BKG_EUR_TRO_DTL TRO_DTL  -- 구주" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("H.BKG_NO = TRO_DTL.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${area_conti_cd} == 'E')" ).append("\n"); 
		query.append("AND H.CNTR_NO = TRO_HDR.CNTR_NO" ).append("\n"); 
		query.append("AND TRO_HDR.BKG_NO = TRO_DTL.BKG_NO" ).append("\n"); 
		query.append("AND TRO_HDR.IO_BND_CD = TRO_DTL.IO_BND_CD" ).append("\n"); 
		query.append("AND TRO_HDR.TRO_SEQ = TRO_DTL.TRO_SEQ" ).append("\n"); 
		query.append("#elseif (${area_conti_cd} == 'X')" ).append("\n"); 
		query.append("AND H.CNTR_NO = TRO_DTL.CNTR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND H.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND TRO_DTL.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND TRO_DTL.TRO_SEQ = @[tro_seq]" ).append("\n"); 
		query.append("AND TRO_DTL.TRO_SUB_SEQ = @[tro_sub_seq]" ).append("\n"); 
		query.append("#if (${area_conti_cd} == 'X')" ).append("\n"); 
		query.append("AND NVL(TRO_DTL.RTN_TRO_FLG, 'N') = 'N' -- 'Y' 인건은 S/O 가 발생하지 않으며 한국지역에서만 생김" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NVL(H.IB_TRO_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND H.COP_STS_CD IN ('C'," ).append("\n"); 
		query.append("'T'," ).append("\n"); 
		query.append("'F')" ).append("\n"); 
		query.append("AND H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("AND D.ACT_CD IN ('FUWMUD'," ).append("\n"); 
		query.append("'FUVMUD'," ).append("\n"); 
		query.append("'FUWMAD'," ).append("\n"); 
		query.append("'FUVMAD')" ).append("\n"); 
		query.append("AND ROWNUM < 3 ) A" ).append("\n"); 
		query.append("WHERE A.ACT_CD IN ('FUWMUD'," ).append("\n"); 
		query.append("'FUVMUD')" ).append("\n"); 

	}
}