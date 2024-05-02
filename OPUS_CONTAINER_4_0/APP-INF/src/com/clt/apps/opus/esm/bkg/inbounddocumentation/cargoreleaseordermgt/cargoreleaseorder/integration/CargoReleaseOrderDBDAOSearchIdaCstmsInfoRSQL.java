/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchIdaCstmsInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.03 
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

public class CargoReleaseOrderDBDAOSearchIdaCstmsInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI-BKG-0680 India Cargo Release - inquery india custms info
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchIdaCstmsInfoRSQL(){
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
		query.append("FileName : CargoReleaseOrderDBDAOSearchIdaCstmsInfoRSQL").append("\n"); 
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
		query.append("/* return IdaCstmsVO */" ).append("\n"); 
		query.append("SELECT NVL( TRIM(DREF.IDA_IMP_GEN_MF_NO), IVSL.IDA_DECL_VSL_NO ) AS IDA_IMP_GEN_MF_NO" ).append("\n"); 
		query.append(", NVL( TRIM(DREF.IDA_CGOR_ORD_YR), IVSL.IDA_YR_NO )         AS IDA_CGOR_ORD_YR" ).append("\n"); 
		query.append(", NVL(TRIM(DREF.IDA_CSTMS_ASGN_LINE_NO), IVSL.IDA_LINE_NO)   AS IDA_CSTMS_ASGN_LINE_NO" ).append("\n"); 
		query.append(", 'N' AS TROI_FLG" ).append("\n"); 
		query.append("FROM  BKG_BOOKING BKGM" ).append("\n"); 
		query.append(", BKG_VVD BVVD" ).append("\n"); 
		query.append(", BKG_DO_REF DREF" ).append("\n"); 
		query.append(", BKG_CSTMS_IDA_VSL IVSL" ).append("\n"); 
		query.append("WHERE BKGM.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND DREF.BKG_NO(+) = BKGM.BKG_NO" ).append("\n"); 
		query.append("AND BVVD.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("AND BVVD.POD_CD = BKGM.POD_CD" ).append("\n"); 
		query.append("AND BVVD.VSL_PRE_PST_CD IN ('T', 'U')" ).append("\n"); 
		query.append("AND IVSL.VSL_CD(+)    = BVVD.VSL_CD" ).append("\n"); 
		query.append("AND IVSL.SKD_VOY_NO(+) = BVVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND IVSL.SKD_DIR_CD(+) = BVVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND IVSL.POD_CD(+)     = BVVD.POD_CD" ).append("\n"); 

	}
}