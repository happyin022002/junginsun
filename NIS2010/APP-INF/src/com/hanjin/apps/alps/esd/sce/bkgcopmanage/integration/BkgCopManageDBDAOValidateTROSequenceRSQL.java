/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BkgCopManageDBDAOValidateTROSequenceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOValidateTROSequenceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 기 발행되어 처리된 TRO 내역을 확인한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOValidateTROSequenceRSQL(){
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
		params.put("area_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : BkgCopManageDBDAOValidateTROSequenceRSQL").append("\n"); 
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
		query.append("SELECT M.COP_NO, M.IO_BND_CD, M.AREA_CONTI_CD, M.BKG_NO, M.TRO_SEQ, M.TRO_SUB_SEQ, H.CNTR_NO" ).append("\n"); 
		query.append("FROM SCE_TRO_MAPG M, SCE_COP_HDR H" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND M.COP_NO = H.COP_NO" ).append("\n"); 
		query.append("AND M.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND M.IO_BND_CD = @[io_bnd_cd] " ).append("\n"); 
		query.append("#if (${tro_seq} != '')" ).append("\n"); 
		query.append("	AND M.TRO_SEQ = @[tro_seq]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tro_sub_seq} != '')" ).append("\n"); 
		query.append("	AND M.TRO_SUB_SEQ = @[tro_sub_seq] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${area_conti_cd} != '') " ).append("\n"); 
		query.append("	AND AREA_CONTI_CD = @[area_conti_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}