/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOApprovalInformationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.23
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2010.08.23 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOApprovalInformationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOApprovalInformationVORSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOApprovalInformationVORSQL").append("\n"); 
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
		query.append("BC.RGN_CD" ).append("\n"); 
		query.append(",   SUBSTR(BC.OLD_POR_YD_CD, 1, 5) OLD_POR" ).append("\n"); 
		query.append(",   SUBSTR(BC.OLD_POL_YD_CD, 1, 5) OLD_POL" ).append("\n"); 
		query.append(",   SUBSTR(BC.OLD_POD_YD_CD, 1, 5) OLD_POD" ).append("\n"); 
		query.append(",   SUBSTR(BC.OLD_DEL_YD_CD, 1, 5) OLD_DEL" ).append("\n"); 
		query.append(",   SUBSTR(BC.NEW_POR_YD_CD, 1, 5) NEW_POR" ).append("\n"); 
		query.append(",   SUBSTR(BC.NEW_POL_YD_CD, 1, 5) NEW_POL" ).append("\n"); 
		query.append(",   SUBSTR(BC.NEW_POD_YD_CD, 1, 5) NEW_POD" ).append("\n"); 
		query.append(",   SUBSTR(BC.NEW_DEL_YD_CD, 1, 5) NEW_DEL" ).append("\n"); 
		query.append(",   BC.OLD_VSL_CD" ).append("\n"); 
		query.append(",   BC.OLD_SKD_VOY_NO" ).append("\n"); 
		query.append(",   BC.OLD_SKD_DIR_CD" ).append("\n"); 
		query.append(",   BC.OLD_VSL_CD||BC.OLD_SKD_VOY_NO||BC.OLD_SKD_DIR_CD OLD_VVD" ).append("\n"); 
		query.append(",   BC.NEW_VSL_CD" ).append("\n"); 
		query.append(",   BC.NEW_SKD_VOY_NO" ).append("\n"); 
		query.append(",   BC.NEW_SKD_DIR_CD" ).append("\n"); 
		query.append(",   BC.NEW_VSL_CD||BC.NEW_SKD_VOY_NO||BC.NEW_SKD_DIR_CD NEW_VVD" ).append("\n"); 
		query.append(",   BC.OLD_POL_YD_CD" ).append("\n"); 
		query.append(",   BC.OLD_POD_YD_CD" ).append("\n"); 
		query.append(",   BC.NEW_POL_YD_CD" ).append("\n"); 
		query.append(",   BC.NEW_POD_YD_CD" ).append("\n"); 
		query.append(",   BC.DIFF_RMK" ).append("\n"); 
		query.append("--,   BC.COD_RQST_RSN_CD --COD Reason 출력" ).append("\n"); 
		query.append(",   (SELECT INTG_CD_VAL_CTNT||' : '||INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE  INTG_CD_ID = 'CD02153'" ).append("\n"); 
		query.append("AND    INTG_CD_VAL_CTNT = BC.COD_RQST_RSN_CD" ).append("\n"); 
		query.append(") AS COD_RQST_RSN_CD --COD Reason 출력" ).append("\n"); 
		query.append(",   BC.COD_RQST_SEQ" ).append("\n"); 
		query.append(",   BC.COD_RHND_PORT_CD --Re-Handling PORT 출력" ).append("\n"); 
		query.append(",   BC.COD_STS_CD" ).append("\n"); 
		query.append(",   BC.COD_RJCT_CD" ).append("\n"); 
		query.append(",   BC.BKG_NO" ).append("\n"); 
		query.append(",   BC.CRE_USR_ID" ).append("\n"); 
		query.append(",   (SELECT USR_NM" ).append("\n"); 
		query.append("FROM   COM_USER" ).append("\n"); 
		query.append("WHERE  USR_ID=BC.CRE_USR_ID) AS CRE_USR_NM" ).append("\n"); 
		query.append(",   (SELECT  L.LOC_NM" ).append("\n"); 
		query.append("FROM    MDM_LOCATION L" ).append("\n"); 
		query.append("WHERE   L.LOC_CD     = SUBSTR(BC.OLD_POL_YD_CD,1,5)) AS POL_FULL_NM" ).append("\n"); 
		query.append(",   (SELECT  L.LOC_NM" ).append("\n"); 
		query.append("FROM    MDM_LOCATION L" ).append("\n"); 
		query.append("WHERE   L.LOC_CD     = SUBSTR(BC.OLD_POD_YD_CD,1,5)) AS OLD_POD_FULL_NM" ).append("\n"); 
		query.append(",   (SELECT  L.LOC_NM" ).append("\n"); 
		query.append("FROM    MDM_LOCATION L" ).append("\n"); 
		query.append("WHERE   L.LOC_CD     = SUBSTR(BC.NEW_POD_YD_CD,1,5)) AS NEW_POD_FULL_NM" ).append("\n"); 
		query.append(",   TO_CHAR(SYSDATE,'YYYY/MM/DD') AS CRE_DT" ).append("\n"); 
		query.append(",   (SELECT   VC.VSL_ENG_NM" ).append("\n"); 
		query.append("FROM     MDM_VSL_CNTR VC" ).append("\n"); 
		query.append("WHERE    VC.VSL_CD    = BC.OLD_VSL_CD) AS VSL_ENG_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",   (SELECT     SUBSTR(VVD.POD_YD_CD,1,5)" ).append("\n"); 
		query.append("FROM       BKG_COD_VVD              VVD" ).append("\n"); 
		query.append("WHERE      VVD.BKG_NO               = BC.BKG_NO" ).append("\n"); 
		query.append("AND        VVD.COD_RQST_SEQ         = @[cod_rqst_seq]" ).append("\n"); 
		query.append("AND        VVD.VVD_OP_CD            = 'O'" ).append("\n"); 
		query.append("AND        VVD.VSL_PRE_PST_CD       = 'T'" ).append("\n"); 
		query.append("AND        VVD.VSL_SEQ              = 0" ).append("\n"); 
		query.append(") AS TRK_OLD_POD_CD" ).append("\n"); 
		query.append(",   (SELECT     ML.LOC_NM" ).append("\n"); 
		query.append("FROM       MDM_LOCATION  ML" ).append("\n"); 
		query.append("WHERE      ML.LOC_CD     = (SELECT     SUBSTR(VVD.POD_YD_CD,1,5)" ).append("\n"); 
		query.append("FROM       BKG_COD_VVD              VVD" ).append("\n"); 
		query.append("WHERE      VVD.BKG_NO               = BC.BKG_NO" ).append("\n"); 
		query.append("AND        VVD.COD_RQST_SEQ         = @[cod_rqst_seq]" ).append("\n"); 
		query.append("AND        VVD.VVD_OP_CD            = 'O'      -- O:Original, N:New" ).append("\n"); 
		query.append("AND        VVD.VSL_PRE_PST_CD       = 'T'      -- T:Trunk" ).append("\n"); 
		query.append("AND        VVD.VSL_SEQ              = 0        -- 0 (Fix)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") AS TRK_OLD_POD_FULL_NM" ).append("\n"); 
		query.append(",   (SELECT     SUBSTR(VVD.POD_YD_CD,1,5)" ).append("\n"); 
		query.append("FROM       BKG_COD_VVD              VVD" ).append("\n"); 
		query.append("WHERE      VVD.BKG_NO               = BC.BKG_NO" ).append("\n"); 
		query.append("AND        VVD.COD_RQST_SEQ         = @[cod_rqst_seq]" ).append("\n"); 
		query.append("AND        VVD.VVD_OP_CD            = 'N'" ).append("\n"); 
		query.append("AND        VVD.VSL_PRE_PST_CD       = 'T'" ).append("\n"); 
		query.append("AND        VVD.VSL_SEQ              = 0" ).append("\n"); 
		query.append(") AS TRK_NEW_POD_CD" ).append("\n"); 
		query.append(",   (SELECT     ML.LOC_NM" ).append("\n"); 
		query.append("FROM       MDM_LOCATION  ML" ).append("\n"); 
		query.append("WHERE      ML.LOC_CD     = (SELECT     SUBSTR(VVD.POD_YD_CD,1,5)" ).append("\n"); 
		query.append("FROM       BKG_COD_VVD              VVD" ).append("\n"); 
		query.append("WHERE      VVD.BKG_NO               = BC.BKG_NO" ).append("\n"); 
		query.append("AND        VVD.COD_RQST_SEQ         = @[cod_rqst_seq]" ).append("\n"); 
		query.append("AND        VVD.VVD_OP_CD            = 'N'      -- O:Original, N:New" ).append("\n"); 
		query.append("AND        VVD.VSL_PRE_PST_CD       = 'T'      -- T:Trunk" ).append("\n"); 
		query.append("AND        VVD.VSL_SEQ              = 0        -- 0 (Fix)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") AS TRK_NEW_POD_FULL_NM" ).append("\n"); 
		query.append("FROM  BKG_COD BC" ).append("\n"); 
		query.append("WHERE BC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   BC.COD_RQST_SEQ = @[cod_rqst_seq]" ).append("\n"); 

	}
}