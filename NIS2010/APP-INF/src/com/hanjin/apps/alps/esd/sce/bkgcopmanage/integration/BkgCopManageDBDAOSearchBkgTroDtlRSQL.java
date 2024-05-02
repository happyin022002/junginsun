/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchBkgTroDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.10.21 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchBkgTroDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_TRO_DTL 정보를 조회한다. 단 RTN_TRO_FLG 가 'N' 인 건만 조회
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchBkgTroDtlRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_sub_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchBkgTroDtlRSQL").append("\n"); 
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
		query.append("BKG_NO," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("RTN_TRO_FLG," ).append("\n"); 
		query.append("TRO_SEQ," ).append("\n"); 
		query.append("TRO_SUB_SEQ," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("TRO_QTY," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("TO_CHAR(DOR_ARR_DT, 'YYYYMMDDHH24MISS') AS DOR_ARR_DT," ).append("\n"); 
		query.append("PKUP_LOC_CD," ).append("\n"); 
		query.append("PKUP_YD_CD," ).append("\n"); 
		query.append("RTN_LOC_CD," ).append("\n"); 
		query.append("RTN_YD_CD," ).append("\n"); 
		query.append("CMDT_CD," ).append("\n"); 
		query.append("PCTL_NO," ).append("\n"); 
		query.append("CXL_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_TRO_DTL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("and IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND RTN_TRO_FLG = 'N'" ).append("\n"); 
		query.append("and TRO_SEQ = @[tro_seq]" ).append("\n"); 
		query.append("and TRO_SUB_SEQ = @[tro_sub_seq]" ).append("\n"); 

	}
}