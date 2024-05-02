/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOSearchCHSAssetsDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.06.09 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NamKoong JinHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOSearchCHSAssetsDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCHSAssetsDetailList
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOSearchCHSAssetsDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_prd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mftr_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnfr_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_prd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOSearchCHSAssetsDetailListRSQL").append("\n"); 
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
		query.append("    ROWNUM AS SEQ," ).append("\n"); 
		query.append("    B.VNDR_ABBR_NM," ).append("\n"); 
		query.append("    C.VNDR_SEQ AS MFTR_VNDR_SEQ," ).append("\n"); 
		query.append("    A.EQ_TPSZ_CD AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    A.AGMT_LSTM_CD AS LSTM_CD," ).append("\n"); 
		query.append("    A.EQ_NO AS CNTR_NO," ).append("\n"); 
		query.append("    TO_CHAR(A.MFT_DT,'YYYY-MM-DD') AS MFT_DT," ).append("\n"); 
		query.append("    D.EQ_ASET_STS_CD AS CNTR_STS_CD,    " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT   EQ_LOT_NO " ).append("\n"); 
		query.append("        FROM CGM_EQ_LOT Z" ).append("\n"); 
		query.append("        WHERE Z.EQ_PFX_CD  = SUBSTR(A.EQ_NO,0,4)" ).append("\n"); 
		query.append("        AND   Z.FM_SER_NO <= TO_NUMBER(SUBSTR(A.EQ_NO,5,6)) " ).append("\n"); 
		query.append("        AND   Z.TO_SER_NO >= TO_NUMBER(SUBSTR(A.EQ_NO,5,6))                          " ).append("\n"); 
		query.append("    ) AS LOT_NO,    " ).append("\n"); 
		query.append("    F.RCC_CD," ).append("\n"); 
		query.append("    F.LCC_CD," ).append("\n"); 
		query.append("    A.CRNT_YD_CD," ).append("\n"); 
		query.append("    A.CHSS_MVMT_STS_CD AS CNMV_STS_CD," ).append("\n"); 
		query.append("    TO_CHAR(A.CHSS_MVMT_DT ,'YYYY-MM-DD') AS CNMV_DT," ).append("\n"); 
		query.append("    A.EQ_SPEC_NO" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A, " ).append("\n"); 
		query.append("     MDM_VENDOR B, " ).append("\n"); 
		query.append("     CGM_EQ_SPEC C," ).append("\n"); 
		query.append("     CGM_EQ_STS_HIS D," ).append("\n"); 
		query.append("     MDM_LOCATION E," ).append("\n"); 
		query.append("     MDM_EQ_ORZ_CHT F" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.EQ_SPEC_NO = C.EQ_SPEC_NO(+)" ).append("\n"); 
		query.append("AND C.VNDR_SEQ   = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.EQ_NO      = D.EQ_NO" ).append("\n"); 
		query.append("AND A.EQ_STS_SEQ = D.EQ_STS_SEQ" ).append("\n"); 
		query.append("AND E.SCC_CD     = F.SCC_CD" ).append("\n"); 
		query.append("AND A.CRNT_LOC_CD =  E.LOC_CD  " ).append("\n"); 
		query.append("#if (${mftr_vndr_seq} != '') " ).append("\n"); 
		query.append("AND C.VNDR_SEQ = @[mftr_vndr_seq]        --Manufacturer-- " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("    AND A.EQ_TPSZ_CD  IN ( " ).append("\n"); 
		query.append("		#foreach($cntrtpszcd in ${vel_tpsz_cd})  " ).append("\n"); 
		query.append("			'$cntrtpszcd',  " ).append("\n"); 
		query.append("			#end  " ).append("\n"); 
		query.append("			'') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mnfr_yr} != '') " ).append("\n"); 
		query.append("AND A.MFT_DT >= TO_DATE(@[mnfr_yr] || '0101 000000','yyyymmdd HH24MISS') AND A.MFT_DT <= TO_DATE(@[mnfr_yr] || '1231 235959','yyyymmdd HH24MISS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.MFT_DT IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_prd} != '') " ).append("\n"); 
		query.append("AND A.MFT_DT >= TO_DATE(@[fm_prd],'YYYYMM') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${to_prd} != '') " ).append("\n"); 
		query.append("AND A.MFT_DT <  ADD_MONTHS(TO_DATE(@[to_prd],'YYYYMM'),1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lstm_cd} == 'ALL') " ).append("\n"); 
		query.append("AND A.AGMT_LSTM_CD IN ('OW','LP','OL')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.AGMT_LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND DECODE(NVL(@[loc_tp_cd],'ALL'),'ALL','1','RCC',F.RCC_CD,'LCC',F.LCC_CD,'ECC',F.ECC_CD,'SCC',F.SCC_CD) = DECODE(NVL(@[loc_tp_cd],'ALL'),'ALL','1',@[loc_cd])    " ).append("\n"); 
		query.append("#if (${cntr_pfx_cd} != '') " ).append("\n"); 
		query.append("AND A.EQ_NO LIKE @[cntr_pfx_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_ser_no} != '') " ).append("\n"); 
		query.append("AND TO_NUMBER(@[fm_ser_no]) <= TO_NUMBER(SUBSTR(A.EQ_NO,5,6)) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${to_ser_no} != '') " ).append("\n"); 
		query.append("AND TO_NUMBER(SUBSTR(A.EQ_NO,5,6)) <= TO_NUMBER(@[to_ser_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}