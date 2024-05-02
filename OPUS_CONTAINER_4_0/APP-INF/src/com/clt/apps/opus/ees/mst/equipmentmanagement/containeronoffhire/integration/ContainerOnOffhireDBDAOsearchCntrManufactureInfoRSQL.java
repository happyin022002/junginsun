/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOsearchCntrManufactureInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOsearchCntrManufactureInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCntrManufactureInfo
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOsearchCntrManufactureInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstmcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mft_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ceflg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("deflg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOsearchCntrManufactureInfoRSQL").append("\n"); 
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
		query.append("#if (${cntr_no} == '') " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  A.CNTR_NO" ).append("\n"); 
		query.append(" ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(" ,A.LSTM_CD" ).append("\n"); 
		query.append(" ,TO_CHAR(A.ONH_DT, 'YYYY-MM-DD') ONH_DT" ).append("\n"); 
		query.append(" ,A.ONH_YD_CD" ).append("\n"); 
		query.append(" ,TO_CHAR(A.MFT_DT, 'YYYY-MM-DD') MFT_DT" ).append("\n"); 
		query.append(" ,DECODE(A.MFTR_VNDR_SEQ, 0, '', A.MFTR_VNDR_SEQ) MFTR_VNDR_SEQ" ).append("\n"); 
		query.append(" ,A.VNDR_SEQ" ).append("\n"); 
		query.append(" ,NVL(B.VNDR_ABBR_NM, B.VNDR_LGL_ENG_NM)  MFTR_VNDR_NM" ).append("\n"); 
		query.append(" ,'' aeflg" ).append("\n"); 
		query.append(" ,'' beflg" ).append("\n"); 
		query.append(" ,'' ceflg" ).append("\n"); 
		query.append(" ,'' deflg" ).append("\n"); 
		query.append(" ,'' eeflg" ).append("\n"); 
		query.append("FROM MST_CONTAINER A, MDM_VENDOR B" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#if (${lstmcd} != '')" ).append("\n"); 
		query.append("AND A.LSTM_CD = @[lstmcd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.LSTM_CD IN ('ST', 'LT')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${md_flg} != 'N')" ).append("\n"); 
		query.append("AND A.MFT_DT IS NOT NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.MFT_DT IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${m_flg} != 'N')" ).append("\n"); 
		query.append("AND NVL(A.MFTR_VNDR_SEQ, 0) <> 0" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND NVL(A.MFTR_VNDR_SEQ, 0) = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--AND A.CNTR_STS_CD NOT IN ('LSO','TLL','LST') 2010.07.15 수정" ).append("\n"); 
		query.append("AND A.CNTR_STS_CD NOT IN ('LSO','TLL','DIO')" ).append("\n"); 
		query.append("#if (${agmt_cty_cd} != '' && ${agmt_seq} != '')" ).append("\n"); 
		query.append("AND A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND A.AGMT_SEQ    = @[agmt_seq]			" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.VNDR_SEQ(+) = A.MFTR_VNDR_SEQ" ).append("\n"); 
		query.append("ORDER BY A.CNTR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  A.CNTR_NO" ).append("\n"); 
		query.append(" ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(" ,A.LSTM_CD" ).append("\n"); 
		query.append(" ,TO_CHAR(A.ONH_DT, 'YYYY-MM-DD') ONH_DT" ).append("\n"); 
		query.append(" ,A.ONH_YD_CD" ).append("\n"); 
		query.append(" ,@[mft_dt] MFT_DT" ).append("\n"); 
		query.append(" ,@[mftr_vndr_seq] MFTR_VNDR_SEQ" ).append("\n"); 
		query.append(" ,A.VNDR_SEQ" ).append("\n"); 
		query.append("#if (${beflg} != 'E')" ).append("\n"); 
		query.append(" ,(SELECT NVL(B.VNDR_ABBR_NM,VNDR_LGL_ENG_NM) CODE_NM" ).append("\n"); 
		query.append("   FROM MDM_VENDOR B" ).append("\n"); 
		query.append("   WHERE B.VNDR_SEQ = @[mftr_vndr_seq]" ).append("\n"); 
		query.append("   AND NVL(B.DELT_FLG, 'N') = 'N') MFTR_VNDR_NM" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" , '' MFTR_VNDR_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ,DECODE(A.LSTM_CD, 'ST', '' ,'LT', '', 'E')  aeflg" ).append("\n"); 
		query.append("#if (${beflg} != 'E')" ).append("\n"); 
		query.append(" ,DECODE((SELECT COUNT(1)" ).append("\n"); 
		query.append("          FROM MDM_CNTR_VNDR_CLSS A," ).append("\n"); 
		query.append("               MDM_VENDOR B" ).append("\n"); 
		query.append("          WHERE A.CNTR_VNDR_SVC_CD ='MFR'" ).append("\n"); 
		query.append("          AND A.VNDR_SEQ = @[mftr_vndr_seq]" ).append("\n"); 
		query.append("          AND A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("          AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("          AND NVL(B.DELT_FLG, 'N') = 'N'),0,'E','') beflg" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${mftr_vndr_seq}=='') -- mftr_vndr_seq가 null인경우는 처리한다." ).append("\n"); 
		query.append("		 ,'' beflg" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		 ,'E' beflg" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mft_dt}=='')  -- mft_dt가 null인경우는 처리한다." ).append("\n"); 
		query.append(" ,'' ceflg" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" ,DECODE(@[ceflg],'E','E','') ceflg" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ,DECODE(@[deflg],'E','E','') deflg" ).append("\n"); 
		query.append(" ,'' eeflg" ).append("\n"); 
		query.append("FROM MST_CONTAINER A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}