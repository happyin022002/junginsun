/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPSAIFInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.07
*@LastModifier : 
*@LastVersion : 1.0
* 2010.10.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchPSAIFInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSA Interface 조회
	  * 2010.09.07 김영철 [CHM-201005693-01] BKG_SEQ MAX값을 구하는 부분 수정
	  * 2010.10.07 김영철 [ ] SQL문 튜닝
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPSAIFInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOsearchPSAIFInfoRSQL").append("\n"); 
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
		query.append("SELECT PBR.SUB_PSA_SER_NO SUB_PSA_SER_NO" ).append("\n"); 
		query.append(", PB.PSA_IF_CD PSA_IF_CD" ).append("\n"); 
		query.append(", PBC.PSA_SER_NO PSA_SER_NO" ).append("\n"); 
		query.append(", PB.BKG_NO BKG_NO" ).append("\n"); 
		query.append(", PB.BKG_SEQ BKG_SEQ" ).append("\n"); 
		query.append(", TO_CHAR( PB.SND_DT, 'YYYY-MM-DD HH24:MI') SND_DT" ).append("\n"); 
		query.append(", PB.SND_USR_ID SND_USR_ID" ).append("\n"); 
		query.append(", PBR.YD_CD YD_CD" ).append("\n"); 
		query.append(", PBR.CNTR_TPSZ_CD CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", LTRIM(TO_CHAR(NVL(SUM( CNTR_QTY ), 0),'990.99')) CNTR_QTY" ).append("\n"); 
		query.append(", PBR.CNTR_TPSZ_CD||'-'||LTRIM(TO_CHAR(NVL(SUM( CNTR_QTY ), 0),'990.99')) BKG_QTY" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_PSA_BKG     PB," ).append("\n"); 
		query.append("BKG_CSTMS_PSA_RLSE_ORD  PBR," ).append("\n"); 
		query.append("BKG_CSTMS_PSA_CNTR PBC" ).append("\n"); 
		query.append("WHERE   PBR.BKG_NO          =   PBC.BKG_NO" ).append("\n"); 
		query.append("AND     PBR.BKG_SEQ         =   PBC.BKG_SEQ" ).append("\n"); 
		query.append("AND     PBR.PSA_SER_NO      =   PBC.PSA_SER_NO" ).append("\n"); 
		query.append("AND     PBR.PSA_IF_CD       =   PBC.PSA_IF_CD" ).append("\n"); 
		query.append("AND     PB.BKG_NO           =   PBC.BKG_NO" ).append("\n"); 
		query.append("AND     PB.BKG_SEQ          =   PBC.BKG_SEQ" ).append("\n"); 
		query.append("AND     PB.PSA_IF_CD        =   PBC.PSA_IF_CD" ).append("\n"); 
		query.append("AND     PB.BKG_NO           =   @[bkg_no]" ).append("\n"); 
		query.append("AND     PB.BKG_SEQ          IN   ( SELECT A.BKG_SEQ" ).append("\n"); 
		query.append("FROM BKG_CSTMS_PSA_RLSE_ORD A, BKG_CSTMS_PSA_BKG B," ).append("\n"); 
		query.append("( SELECT PB1.BKG_NO BKG_NO, MAX(PB1.SND_DT) SND_DT, PBR1.CNTR_TPSZ_CD CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_PSA_RLSE_ORD PBR1, BKG_QUANTITY QTY, BKG_CSTMS_PSA_BKG PB1" ).append("\n"); 
		query.append("WHERE PBR1.BKG_NO = QTY.BKG_NO" ).append("\n"); 
		query.append("AND PB1.BKG_NO = QTY.BKG_NO" ).append("\n"); 
		query.append("AND PB1.BKG_SEQ = PBR1.BKG_SEQ" ).append("\n"); 
		query.append("AND PBR1.CNTR_TPSZ_CD = QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND PBR1.BKG_NO       =  @[bkg_no]" ).append("\n"); 
		query.append("GROUP BY PB1.BKG_NO, PBR1.CNTR_TPSZ_CD ) C" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.BKG_SEQ = B.BKG_SEQ" ).append("\n"); 
		query.append("AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND B.SND_DT = C.SND_DT" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD )" ).append("\n"); 
		query.append("GROUP BY    PBR.SUB_PSA_SER_NO," ).append("\n"); 
		query.append("PB.PSA_IF_CD," ).append("\n"); 
		query.append("PBC.PSA_SER_NO," ).append("\n"); 
		query.append("PB.BKG_NO, PB.BKG_SEQ," ).append("\n"); 
		query.append("TO_CHAR( PB.SND_DT,'YYYY-MM-DD HH24:MI' ) ," ).append("\n"); 
		query.append("PB.SND_USR_ID   ," ).append("\n"); 
		query.append("PBR.CNTR_TPSZ_CD   ," ).append("\n"); 
		query.append("PBR.YD_CD" ).append("\n"); 
		query.append("ORDER BY    PB.BKG_NO, PB.BKG_SEQ ," ).append("\n"); 
		query.append("TO_CHAR( PB.SND_DT,'YYYY-MM-DD HH24:MI' ) ," ).append("\n"); 
		query.append("PB.SND_USR_ID   ," ).append("\n"); 
		query.append("PBR.CNTR_TPSZ_CD   ," ).append("\n"); 
		query.append("PBR.YD_CD" ).append("\n"); 

	}
}