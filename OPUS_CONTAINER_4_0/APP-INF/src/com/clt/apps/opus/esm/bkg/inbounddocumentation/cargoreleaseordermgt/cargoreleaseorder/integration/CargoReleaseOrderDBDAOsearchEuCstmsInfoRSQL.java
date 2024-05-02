/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEuCstmsInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchEuCstmsInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * POD에 따라서 Default값은CRN(ROCS), SSR(ANCS), UVI(FXT)에 Assign된 값
	  * POD가 NLRTM인 경우, ROCS의 CRN List에서 해당 B/L에 Assign된 CRN No를 가져옴
	  * POD가 BEANR인 경우, ANCS의 SSR Creation에서 해당 B/L에 Assign된 SSR No를 가져옴
	  * POD가 GBFXT인 경우, EU Customs EDI에서 해당 B/L에 Assign된 UVI No를 가져옴
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEuCstmsInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchEuCstmsInfoRSQL").append("\n"); 
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
		query.append("SELECT NVL(DREF.CSTMS_REF_NM, 'Customs Ref. No') as cstms_ref_nm" ).append("\n"); 
		query.append(",NVL(DREF.CSTMS_REF_CTNT, DECODE(SUB.POD_CD,'NLRTM',CRN_NO ," ).append("\n"); 
		query.append("'BEANR',SSR_NO," ).append("\n"); 
		query.append("'GBFXT',UVI_NO,'')) as cstms_ref_ctnt" ).append("\n"); 
		query.append(",NVL(DREF.CSTMS_ASGN_NM,'Customs Ref. No') as cstms_asgn_nm" ).append("\n"); 
		query.append(",NVL(DREF.CSTMS_ASGN_CTNT,DECODE(SUB.POD_CD,'BEANR',ARTICLE_NO ,'')) as cstms_asgn_ctnt" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  BKGM.BKG_NO                      AS BKG_NO" ).append("\n"); 
		query.append(",BKGM.POD_CD                      AS POD_CD" ).append("\n"); 
		query.append(",RBL.VSL_CALL_REF_NO              AS CRN_NO      -- CRN No" ).append("\n"); 
		query.append(",RBL.IB_FILE_SEQ                  AS FILER       -- Filer" ).append("\n"); 
		query.append(",AVVD.SVC_RQST_NO                 AS SSR_NO      -- SSR NO" ).append("\n"); 
		query.append(",LPAD(NVL(ABL.VVD_SEQ,'') ,4,'0') AS ARTICLE_NO  -- Articl No" ).append("\n"); 
		query.append(",DYD.CVY_REF_NO                   AS UVI_NO      -- UVI NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKGM" ).append("\n"); 
		query.append(",BKG_VVD BVVD" ).append("\n"); 
		query.append(",BKG_CSTMS_RTM_BL RBL" ).append("\n"); 
		query.append(",BKG_CSTMS_ANR_BL ABL" ).append("\n"); 
		query.append(",BKG_CSTMS_ANR_VVD AVVD" ).append("\n"); 
		query.append(",BKG_VSL_DCHG_YD DYD" ).append("\n"); 
		query.append("WHERE BKGM.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKGM.BKG_NO = BVVD.BKG_NO" ).append("\n"); 
		query.append("AND BKGM.POD_CD = BVVD.POD_CD" ).append("\n"); 
		query.append("AND BVVD.VSL_PRE_PST_CD IN ('T', 'U')" ).append("\n"); 
		query.append("/* NLRTM */" ).append("\n"); 
		query.append("AND RBL.BKG_NO(+)  =  BKGM.BKG_NO" ).append("\n"); 
		query.append("/*ANRBS */" ).append("\n"); 
		query.append("AND ABL.BKG_NO(+) = BVVD.BKG_NO" ).append("\n"); 
		query.append("AND AVVD.VSL_CD(+)= BVVD.VSL_CD" ).append("\n"); 
		query.append("AND AVVD.SKD_VOY_NO(+) = BVVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND AVVD.SKD_DIR_CD(+) = BVVD.SKD_DIR_CD" ).append("\n"); 
		query.append("/* GBFXT */" ).append("\n"); 
		query.append("AND DYD.VSL_CD(+) = BVVD.VSL_CD" ).append("\n"); 
		query.append("AND DYD.SKD_VOY_NO(+) =BVVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND DYD.SKD_DIR_CD(+) = BVVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND DYD.PORT_CD(+) =BVVD.POD_CD" ).append("\n"); 
		query.append("AND DYD.CLPT_IND_SEQ(+) = 1" ).append("\n"); 
		query.append(") SUB,  BKG_DO_REF DREF" ).append("\n"); 
		query.append("WHERE SUB.BKG_NO = DREF.BKG_NO(+)" ).append("\n"); 

	}
}