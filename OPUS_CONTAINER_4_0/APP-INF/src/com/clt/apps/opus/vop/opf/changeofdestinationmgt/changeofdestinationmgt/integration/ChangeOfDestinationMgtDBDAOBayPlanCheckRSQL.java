/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOBayPlanCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.31
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2010.03.31 장석현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Suk Hyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOBayPlanCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOBayPlanCheckRSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOBayPlanCheckRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) AS CNT" ).append("\n"); 
		query.append("FROM   BKG_COD H, BKG_COD_CNTR D, BAY_PLAN B, VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  H.BKG_NO       = @[bkg_no]  --:bkg_no" ).append("\n"); 
		query.append("AND    H.COD_RQST_SEQ = @[cod_rqst_seq]" ).append("\n"); 
		query.append("AND    H.BKG_NO       = D.BKG_NO" ).append("\n"); 
		query.append("AND    H.COD_RQST_SEQ = D.COD_RQST_SEQ" ).append("\n"); 
		query.append("AND    B.VSL_CD       = SUBSTR( @[vvd], 1, 4 )    --:vsl_cd" ).append("\n"); 
		query.append("AND    B.VOY_NO       = SUBSTR( @[vvd], 5, 4 )    --:skd_voy_no" ).append("\n"); 
		query.append("AND    B.DIR_CD       = SUBSTR( @[vvd], 9, 1 )    --:skd_dir_cd" ).append("\n"); 
		query.append("AND    D.CNTR_NO      = B.ID" ).append("\n"); 
		query.append("AND    B.VSL_CD       = V.VSL_CD" ).append("\n"); 
		query.append("AND    B.VOY_NO       = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    B.DIR_CD       = V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    B.PORT_CD      = V.VPS_PORT_CD" ).append("\n"); 
		query.append("AND    B.PLAN_TYPE    = 'F'" ).append("\n"); 
		query.append("AND    V.CLPT_SEQ     < ( SELECT R.CLPT_SEQ" ).append("\n"); 
		query.append("FROM   BKG_COD H, VSK_VSL_PORT_SKD R--, VSK_VSL_PORT_SKD N" ).append("\n"); 
		query.append("WHERE  H.BKG_NO              = @[bkg_no]  --:bkg_no" ).append("\n"); 
		query.append("AND    H.COD_RQST_SEQ        = @[cod_rqst_seq]" ).append("\n"); 
		query.append("AND    R.VSL_CD              = SUBSTR( @[vvd], 1, 4 )    --:vsl_cd" ).append("\n"); 
		query.append("AND    R.SKD_VOY_NO          = SUBSTR( @[vvd], 5, 4 )    --:skd_voy_no" ).append("\n"); 
		query.append("AND    R.SKD_DIR_CD          = SUBSTR( @[vvd], 9, 1 )    --:skd_dir_cd" ).append("\n"); 
		query.append("AND    H.COD_RHND_PORT_YD_CD = R.YD_CD )" ).append("\n"); 

	}
}