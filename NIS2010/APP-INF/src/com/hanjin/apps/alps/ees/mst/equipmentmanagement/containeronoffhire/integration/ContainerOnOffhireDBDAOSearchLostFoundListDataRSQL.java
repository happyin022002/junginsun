/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchLostFoundListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.16
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOSearchLostFoundListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchLostFoundListData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchLostFoundListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_cntr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_save",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_onh_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSearchLostFoundListDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("         A.CNTR_NO" ).append("\n"); 
		query.append("        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,A.LSTM_CD" ).append("\n"); 
		query.append("        ,A.VNDR_SEQ" ).append("\n"); 
		query.append("        ,A.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("        ,A.CNTR_STS_CD" ).append("\n"); 
		query.append("        ,A.CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("        ,A.LST_STS_YD_CD" ).append("\n"); 
		query.append("        ,A.FULL_FLG" ).append("\n"); 
		query.append("        ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("        ,A.CRNT_YD_CD" ).append("\n"); 
		query.append("        ,A.CNMV_DT" ).append("\n"); 
		query.append("        ,A.H_CHK1  " ).append("\n"); 
		query.append("        ,A.H_CHK2  " ).append("\n"); 
		query.append("        ,A.H_CHK3        " ).append("\n"); 
		query.append("        ,@[h_cntr_sts_cd]		AS H_CNTR_STS_CD" ).append("\n"); 
		query.append("        ,@[h_cnmv_evnt_dt]	AS H_CNMV_EVNT_DT" ).append("\n"); 
		query.append("        ,@[h_onh_yd_cd]		AS H_ONH_YD_CD" ).append("\n"); 
		query.append(",@[cntr_rmk] ct" ).append("\n"); 
		query.append("#if(${cntr_rmk} != '')" ).append("\n"); 
		query.append("		,@[cntr_rmk] CNTR_RMK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    	,CASE WHEN A.H_CHK1 = 'E' THEN ''" ).append("\n"); 
		query.append("    	     WHEN A.H_CHK2 = 'E' THEN ''" ).append("\n"); 
		query.append("    	     WHEN A.H_CHK3 = 'E' THEN ''     " ).append("\n"); 
		query.append("    	ELSE A.CNTR_RMK     " ).append("\n"); 
		query.append("        END CNTR_RMK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("         A.CNTR_NO" ).append("\n"); 
		query.append("        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,A.LSTM_CD" ).append("\n"); 
		query.append("        ,A.VNDR_SEQ" ).append("\n"); 
		query.append("        ,A.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("        ,A.CNTR_STS_CD" ).append("\n"); 
		query.append("        ,A.CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("        ,A.LST_STS_YD_CD" ).append("\n"); 
		query.append("        ,DECODE(A.FULL_FLG,'Y','F','N','M',NULL) FULL_FLG" ).append("\n"); 
		query.append("        ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("        ,A.CRNT_YD_CD" ).append("\n"); 
		query.append("        ,A.CNMV_DT" ).append("\n"); 
		query.append("     ,NVL((SELECT B.CNTR_STS_CD" ).append("\n"); 
		query.append("           FROM   MST_CNTR_PRE_STS B" ).append("\n"); 
		query.append("           WHERE B.CNTR_STS_CD = @[h_cntr_sts_cd]" ).append("\n"); 
		query.append("           AND   B.CNTR_PRE_STS_CD = A.CNTR_STS_CD),'E') H_CHK1  " ).append("\n"); 
		query.append("     ,DECODE(@[h_cntr_sts_cd],'LST',DECODE(@[h_onh_yd_cd],A.CRNT_YD_CD,'O','E'),'O') H_CHK2  " ).append("\n"); 
		query.append("     ,CASE WHEN @[h_cnmv_evnt_dt] >= SUBSTR(A.CNMV_DT,0,4) || SUBSTR(A.CNMV_DT,6,2) || SUBSTR(A.CNMV_DT,9,2) THEN" ).append("\n"); 
		query.append("            'O'" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            'E'" ).append("\n"); 
		query.append("           END H_CHK3        " ).append("\n"); 
		query.append("     ,A.CNTR_RMK" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("	     A.CNTR_NO                    -- CNTR No" ).append("\n"); 
		query.append("	    ,A.CNTR_TPSZ_CD               -- TP/SZ" ).append("\n"); 
		query.append("	    ,A.LSTM_CD                    -- Term" ).append("\n"); 
		query.append("	    ,A.VNDR_SEQ                   -- Lessor" ).append("\n"); 
		query.append("	    ,B.VNDR_LGL_ENG_NM            -- Lessor Name" ).append("\n"); 
		query.append("	    ,A.CNTR_STS_CD                -- EQ Status" ).append("\n"); 
		query.append("	    ,(  SELECT /*+ INDEX_DESC(H XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("	            TO_CHAR(H.CNTR_STS_EVNT_DT,'YYYY-MM-DD') AS CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("	        FROM MST_CNTR_STS_HIS H" ).append("\n"); 
		query.append("	        WHERE H.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("	        AND ROWNUM = 1" ).append("\n"); 
		query.append("	     ) AS CNTR_STS_EVNT_DT        -- EQ Status Date" ).append("\n"); 
		query.append("	     ,LST_STS_YD_CD               -- EQ Status Yard  " ).append("\n"); 
		query.append("	     ,FULL_FLG                    -- F/M  " ).append("\n"); 
		query.append("	     ,CNMV_STS_CD                 -- MVMT Status  " ).append("\n"); 
		query.append("	     ,CRNT_YD_CD                  -- MVMT Yard" ).append("\n"); 
		query.append("	     ,TO_CHAR(CNMV_DT,'YYYY-MM-DD') AS CNMV_DT  -- MVMT Date" ).append("\n"); 
		query.append("	     ,DECODE(@[h_save],'0','','1',CNTR_RMK,'') AS CNTR_RMK		--0:조회, 1:조회저장--" ).append("\n"); 
		query.append("	FROM MST_CONTAINER A, MDM_VENDOR B" ).append("\n"); 
		query.append("	WHERE A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("	AND A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("	) " ).append("\n"); 
		query.append(" 	A" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}