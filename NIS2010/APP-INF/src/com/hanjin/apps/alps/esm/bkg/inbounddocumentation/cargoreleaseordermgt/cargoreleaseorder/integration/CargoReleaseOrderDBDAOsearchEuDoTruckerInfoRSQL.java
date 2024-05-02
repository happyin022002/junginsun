/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEuDoTruckerInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchEuDoTruckerInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EU_Cargo Release Order의 Trucker Setting 정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEuDoTruckerInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_no_split",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchEuDoTruckerInfoRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("SELECT  DCNT.BKG_NO" ).append("\n"); 
		query.append(",DCNT.RLSE_SEQ" ).append("\n"); 
		query.append(",DCNT.CNTR_NO" ).append("\n"); 
		query.append(",NVL(DCNT.TRKR_NM,VD.VNDR_LGL_ENG_NM)  AS TRKR_NM" ).append("\n"); 
		query.append(",NVL(DCNT.TRKR_PHN_NO,VD_CNTC.PHN_NO)  AS TRKR_PHN_NO" ).append("\n"); 
		query.append(",NVL(DCNT.TRKR_MVMT_REF_NO,ACNT.MVMT_REF_NO)  AS TRKR_MVMT_REF_NO" ).append("\n"); 
		query.append(",NVL(DCNT.TRKR_MTY_RTN_YD_CD,ACNT.RTN_YD_CD)  AS TRKR_MTY_RTN_YD_CD" ).append("\n"); 
		query.append("FROM BKG_DO            BDO" ).append("\n"); 
		query.append("JOIN BKG_DO_CNTR DCNT" ).append("\n"); 
		query.append("ON  ( BDO.BKG_NO        = DCNT.BKG_NO" ).append("\n"); 
		query.append("AND BDO.RLSE_SEQ  = DCNT.RLSE_SEQ )" ).append("\n"); 
		query.append("LEFT OUTER JOIN BKG_ARR_NTC_CNTR ACNT" ).append("\n"); 
		query.append("ON  ( ACNT.BKG_NO      = DCNT.BKG_NO" ).append("\n"); 
		query.append("AND ACNT.CNTR_NO = DCNT.CNTR_NO)" ).append("\n"); 
		query.append("LEFT OUTER JOIN TRS_TRSP_SVC_ORD SORD" ).append("\n"); 
		query.append("ON  ( SORD.BKG_NO             = DCNT.BKG_NO" ).append("\n"); 
		query.append("AND SORD.EQ_NO          = DCNT.CNTR_NO" ).append("\n"); 
		query.append("AND SORD.TRSP_SO_STS_CD IN ('P','C','I')" ).append("\n"); 
		query.append("AND SORD.TRSP_BND_CD    = 'I')" ).append("\n"); 
		query.append("LEFT OUTER JOIN MDM_VENDOR VD" ).append("\n"); 
		query.append("ON  ( VD.VNDR_SEQ      = SORD.VNDR_SEQ" ).append("\n"); 
		query.append("AND VD.DELT_FLG  = 'N'     )" ).append("\n"); 
		query.append("LEFT OUTER JOIN MDM_VNDR_CNTC_PNT VD_CNTC" ).append("\n"); 
		query.append("ON  ( VD_CNTC.VNDR_SEQ     = SORD.VNDR_SEQ AND VD_CNTC.PRMRY_CHK_FLG  ='Y'" ).append("\n"); 
		query.append("AND VD_CNTC.PHN_NO   IS NOT NULL" ).append("\n"); 
		query.append("AND VD_CNTC.DELT_FLG = 'N'      )" ).append("\n"); 
		query.append("WHERE BDO.DO_NO        = @[do_no]" ).append("\n"); 
		query.append("AND BDO.DO_NO_SPLIT  = NVL(@[do_no_split],'00')" ).append("\n"); 

	}
}