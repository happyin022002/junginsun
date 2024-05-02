/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSAManifestDBDAOsearchUnmatchBkgCntrListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier :
*@LastVersion : 1.0
* 2010.03.03
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchUnmatchBkgCntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Unmatch하는 BKG CNTR정보를 조회한다. (OPUS 탭 Grid)
	  * </pre>
	  */
	public PSAManifestDBDAOsearchUnmatchBkgCntrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rly_port",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n");
		query.append("FileName : PSAManifestDBDAOsearchUnmatchBkgCntrListRSQL").append("\n");
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
		query.append("SELECT DISTINCT" ).append("\n");
		query.append("VVD2.BKG_NO BKG_NO" ).append("\n");
		query.append(", CNTR.CNTR_NO CNTR_NO" ).append("\n");
		query.append(", SUBSTR(SZ.CNTR_TPSZ_PSA_CD,1,2) CNTR_TP_CD" ).append("\n");
		query.append(", SUBSTR(SZ.CNTR_TPSZ_PSA_CD,3,2) CNTR_SZ_CD" ).append("\n");
		query.append(", STWG_CD" ).append("\n");
		query.append("#if(${trans_tp_cd}!='E')" ).append("\n");
		query.append(", VVD2.POL_CD PORT_CD /** IMPORT일때는 VVD2.POL_CD **/" ).append("\n");
		query.append("#else" ).append("\n");
		query.append(", VVD2.POD_CD PORT_CD /** IMPORT일때는 VVD2.POL_CD **/" ).append("\n");
		query.append("#end" ).append("\n");
		query.append(", DECODE(CDO_TEMP,NULL,'',TO_CHAR(CDO_TEMP,'S090')||'C')||" ).append("\n");
		query.append("DECODE(IMDG_CLSS_CD,NULL,'','IMO'||IMDG_CLSS_CD)||" ).append("\n");
		query.append("DECODE(NVL(OVR_LF_LEN,0),0,'','OWL'||TRIM(TO_CHAR(OVR_LF_LEN,'0900')||'C/'))||" ).append("\n");
		query.append("DECODE(NVL(OVR_RT_LEN,0),0,'','OWR'||TRIM(TO_CHAR(OVR_RT_LEN,'0900')||'C/'))||" ).append("\n");
		query.append("DECODE(NVL(OVR_FWRD_LEN,0),0,'','OLF'||TRIM(TO_CHAR(OVR_FWRD_LEN,'0900'))||'C/')||" ).append("\n");
		query.append("DECODE(NVL(OVR_BKWD_LEN,0),0,'','OLB'||TRIM(TO_CHAR(OVR_BKWD_LEN,'0900'))||'C/')||" ).append("\n");
		query.append("DECODE(NVL(OVR_HGT,0),0,'','OH'||TRIM(TO_CHAR(OVR_HGT,'0900')||'C/')) SPECIAL" ).append("\n");
		query.append("FROM   BKG_VVD VVD2, BKG_CONTAINER CNTR, BKG_BOOKING UD," ).append("\n");
		query.append("BKG_RF_CGO RF, BKG_DG_CGO DG, BKG_AWK_CGO AW, MDM_CNTR_TP_SZ SZ" ).append("\n");
		query.append("WHERE    VVD2.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append("AND      VVD2.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n");
		query.append("AND      VVD2.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n");
		query.append("#if(${trans_tp_cd}!='E')" ).append("\n");
		query.append("AND      VVD2.POD_CD = @[rly_port]   /** IMPORT일때는 VVD2.POD_CD **/" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("AND      VVD2.POL_CD = @[rly_port]   /** IMPORT일때는 VVD2.POD_CD **/" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("AND      VVD2.BKG_NO = CNTR.BKG_NO" ).append("\n");
		query.append("AND      EXISTS (SELECT 'X' FROM BKG_BOOKING BKG, BKG_VVD VVD1" ).append("\n");
		query.append("WHERE VVD2.BKG_NO = BKG.BKG_NO" ).append("\n");
		query.append("AND   BKG.BKG_STS_CD <> 'X'" ).append("\n");
		query.append("AND   VVD1.BKG_NO = BKG.BKG_NO" ).append("\n");
		query.append("#if(${trans_tp_cd}!='E')" ).append("\n");
		query.append("AND   VVD1.POL_CD = @[rly_port]  /** IMPORT일때는  VVD1.POL_CD **/ )" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("AND   VVD1.POD_CD = @[rly_port]  /** IMPORT일때는  VVD1.POL_CD **/ )" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("AND      CNTR.CNTR_TPSZ_CD = SZ.CNTR_TPSZ_CD" ).append("\n");
		query.append("AND      VVD2.BKG_NO = UD.BKG_NO(+)" ).append("\n");
		query.append("AND      CNTR.BKG_NO = RF.BKG_NO(+)" ).append("\n");
		query.append("AND      CNTR.CNTR_NO = RF.CNTR_NO(+)" ).append("\n");
		query.append("AND      CNTR.BKG_NO = DG.BKG_NO(+)" ).append("\n");
		query.append("AND      CNTR.CNTR_NO = DG.CNTR_NO(+)" ).append("\n");
		query.append("AND      CNTR.BKG_NO = AW.BKG_NO(+)" ).append("\n");
		query.append("AND      CNTR.CNTR_NO = AW.CNTR_NO(+)" ).append("\n");

	}
}