/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OceanLinkBackEndDBDAOOceanLinkMergeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanLinkBackEndDBDAOOceanLinkMergeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Ocean Link에 해당하는 Direct Ocean Route의 정보를 수정 또는 생성 한다.
	  * </pre>
	  */
	public OceanLinkBackEndDBDAOOceanLinkMergeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmt_tztm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("remark",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("podprot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dircd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lanecd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("polprot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration").append("\n"); 
		query.append("FileName : OceanLinkBackEndDBDAOOceanLinkMergeUSQL").append("\n"); 
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
		query.append("MERGE INTO PRD_OCN_ROUT A " ).append("\n"); 
		query.append("      USING (select @[polprot]  ORG_LOC_CD,@[podprot]  DEST_LOC_CD, @[lanecd]  VSL_SLAN_CD, @[dircd] SKD_DIR_CD " ).append("\n"); 
		query.append("             from DUAL )  B " ).append("\n"); 
		query.append("      ON  (A.ORG_LOC_CD=B.ORG_LOC_CD AND A.DEST_LOC_CD = B.DEST_LOC_CD AND A.TS_IND_CD='D' AND A.N1ST_LANE_CD = B.VSL_SLAN_CD AND A.N1ST_SKD_DIR_CD = B.SKD_DIR_CD AND A.N1ST_LANE_FDR_FLG = 'N' ) " ).append("\n"); 
		query.append("WHEN MATCHED THEN  " ).append("\n"); 
		query.append("     UPDATE SET UPD_IND_CD ='S' ,N1ST_POL_CD=@[polprot]  ,N1ST_POD_CD=@[podprot], " ).append("\n"); 
		query.append("     OCN_ROUT_PRIO_CD = '1', OCN_ROUT_PRIO_CNG_FLG = 'N', OCN_ROUT_USR_RMK = ''," ).append("\n"); 
		query.append("    TZTM_HRS=TO_NUMBER(@[fmt_tztm_hrs])  ,N1ST_TZTM_HRS=TO_NUMBER(@[fmt_tztm_hrs])  ,N2ND_TZTM_HRS=0 ,N3RD_TZTM_HRS=0 ,N4TH_TZTM_HRS=0 ,N1ST_STAY_TM_HRS=0 ,N2ND_STAY_TM_HRS=0 , " ).append("\n"); 
		query.append("    N3RD_STAY_TM_HRS=0 ,FDR_USD_FLG='Y' ,UPD_OFC_CD=@[cre_ofc_cd]  ,UPD_USR_ID=@[upd_usr_id]  ,OCN_ROUT_UPD_DT=SYSDATE ,OCN_ROUT_RMK=REPLACE(REPLACE(REPLACE(@[remark], CHR(34)),CHR(9),' '), CHR(13)||CHR(10),' ')  || ' - Manually Created by ID: '||@[upd_usr_id] ||' on '||SYSDATE " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN  " ).append("\n"); 
		query.append("     INSERT(ORG_LOC_CD,DEST_LOC_CD,ROUT_SEQ,TS_IND_CD,LNK_KNT, " ).append("\n"); 
		query.append("    OCN_ROUT_PRIO_CD,OCN_ROUT_PRIO_CNG_FLG, UPD_IND_CD,N1ST_POL_CD,N1ST_POD_CD,N1ST_LANE_CD,N1ST_SKD_DIR_CD,N1ST_LANE_FDR_FLG, " ).append("\n"); 
		query.append("    TZTM_HRS,N1ST_TZTM_HRS,N2ND_TZTM_HRS,N3RD_TZTM_HRS,N4TH_TZTM_HRS,N1ST_STAY_TM_HRS,N2ND_STAY_TM_HRS, " ).append("\n"); 
		query.append("    N3RD_STAY_TM_HRS,FDR_USD_FLG,CRE_OFC_CD,UPD_OFC_CD,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT,OCN_ROUT_RMK,OCN_ROUT_UPD_DT)  " ).append("\n"); 
		query.append("    VALUES(@[polprot] ,@[podprot] ,(SELECT NVL(MAX(ROUT_SEQ), 0) + 1 FROM PRD_OCN_ROUT X WHERE X.ORG_LOC_CD  = @[polprot]  AND X.DEST_LOC_CD = @[podprot] ),'D',1, " ).append("\n"); 
		query.append("    '1','N','S',@[polprot] ,@[podprot] ,@[lanecd],@[dircd] ,'N', " ).append("\n"); 
		query.append("    TO_NUMBER(@[fmt_tztm_hrs]) ,TO_NUMBER(@[fmt_tztm_hrs]) ,0,0,0,0,0, " ).append("\n"); 
		query.append("    0,'Y',@[cre_ofc_cd] ,@[cre_ofc_cd] ,@[cre_usr_id] ,SYSDATE,@[upd_usr_id] ,SYSDATE ,REPLACE(REPLACE(REPLACE(@[remark], CHR(34)),CHR(9),' '), CHR(13)||CHR(10),' ')  || ' - Manually Created by ID: '||@[upd_usr_id] ||' on '||SYSDATE ,SYSDATE)" ).append("\n"); 

	}
}