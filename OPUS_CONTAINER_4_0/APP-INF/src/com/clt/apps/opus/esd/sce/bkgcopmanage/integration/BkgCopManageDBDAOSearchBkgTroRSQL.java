/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchBkgTroRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.04.20 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchBkgTroRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_TRO 의 정보를 조회한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchBkgTroRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration ").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchBkgTroRSQL").append("\n"); 
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
		query.append("SELECT 	BKG_NO," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("RTN_TRO_FLG," ).append("\n"); 
		query.append("TRO_SEQ," ).append("\n"); 
		query.append("RCV_TERM_CD," ).append("\n"); 
		query.append("TO_CHAR(RQST_DT, 'YYYYMMDDHH24MISS') AS RQST_DT," ).append("\n"); 
		query.append("ZN_CD," ).append("\n"); 
		query.append("DOR_LOC_CD," ).append("\n"); 
		query.append("DOR_PST_NO," ).append("\n"); 
		query.append("BIZ_RGST_NO," ).append("\n"); 
		query.append("CFM_FLG," ).append("\n"); 
		query.append("TO_CHAR(CFM_DT, 'YYYYMMDDHH24MISS') AS CFM_DT," ).append("\n"); 
		query.append("PCTL_NO," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("POL_CD," ).append("\n"); 
		query.append("POD_CD," ).append("\n"); 
		query.append("TRO_BKG_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_TRO" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND TRO_SEQ = @[tro_seq]" ).append("\n"); 

	}
}