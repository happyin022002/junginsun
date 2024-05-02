/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCollectionOfficeMgtDBDAOSearchCollectionOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.10.29 문중철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Mun Jung Cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCollectionOfficeMgtDBDAOSearchCollectionOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DMT COLLECTION OFFICE관리
	  * EES_DMT_7002
	  * DEM/DET Office Inquiry by Yard
	  * </pre>
	  */
	public DMTCollectionOfficeMgtDBDAOSearchCollectionOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("collectib",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yardlocat",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yarddelyn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yardnodee",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("countrycd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("collectob",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.integration ").append("\n"); 
		query.append("FileName : DMTCollectionOfficeMgtDBDAOSearchCollectionOfficeListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("DMDT_OFC_CD 								AS DMTOFC" ).append("\n"); 
		query.append(", DEM_IB_CLT_FLG 							AS IB" ).append("\n"); 
		query.append(", DEM_OB_CLT_FLG 							AS OB" ).append("\n"); 
		query.append(", YD_CD 									AS YDCODE" ).append("\n"); 
		query.append(", YD_NM 									AS YARDNAME" ).append("\n"); 
		query.append(", NVL(DELT_FLG, 'N') 						AS DEL" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("INTG_CD_ID = 'CD00665'" ).append("\n"); 
		query.append("AND     INTG_CD_VAL_CTNT = YD_CHR_CD" ).append("\n"); 
		query.append(") 										AS CHARACTER" ).append("\n"); 
		query.append(", YD_FCTY_TP_MRN_TML_FLG 					AS MARINE" ).append("\n"); 
		query.append(", YD_FCTY_TP_CY_FLG 						AS CY" ).append("\n"); 
		query.append(", YD_FCTY_TP_CFS_FLG 						AS CFS" ).append("\n"); 
		query.append(", YD_FCTY_TP_RAIL_RMP_FLG 					AS RAIL" ).append("\n"); 
		query.append(", YD_FCTY_TP_BRG_RMP_FLG 					AS BARGE" ).append("\n"); 
		query.append(", YD_FCTY_TP_PSDO_YD_FLG	 				AS PSEUDO" ).append("\n"); 
		query.append(", OFC_CD 									AS CTRLOFC" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_YARD" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${yardlocat} != '' && ${yardnodee} != '' )" ).append("\n"); 
		query.append("AND		YD_CD LIKE @[yardnodee]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${yardlocat} != '' && ${yardnodee} == '' )" ).append("\n"); 
		query.append("AND		YD_CD LIKE @[yardlocat]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${demdetoff} != '' )" ).append("\n"); 
		query.append("AND		DMDT_OFC_CD IN (" ).append("\n"); 
		query.append("#foreach( $dmdt_ofc_cd_p in ${tempDEMDETOFFList})" ).append("\n"); 
		query.append("#if($velocityCount < $tempDEMDETOFFList.size())" ).append("\n"); 
		query.append("'$dmdt_ofc_cd_p'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$dmdt_ofc_cd_p'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${collectib} != 'A' )" ).append("\n"); 
		query.append("AND     NVL(DEM_IB_CLT_FLG, 'N') = @[collectib]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${collectob} != 'A' )" ).append("\n"); 
		query.append("AND     NVL(DEM_OB_CLT_FLG, 'N') = @[collectob]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${yarddelyn} != 'A' )" ).append("\n"); 
		query.append("AND     NVL(DELT_FLG, 'N')       = @[yarddelyn]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${countrycd} != '' )" ).append("\n"); 
		query.append("AND		YD_CD LIKE @[countrycd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}