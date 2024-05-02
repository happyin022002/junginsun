/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoIrregularMgtDBDAOCNTRListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.07.22 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoIrregularMgtDBDAOCNTRListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container 목록 조회
	  * </pre>
	  */
	public SpecialCargoIrregularMgtDBDAOCNTRListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoIrregularMgtDBDAOCNTRListVORSQL").append("\n"); 
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
		query.append("BC.CNTR_NO" ).append("\n"); 
		query.append(",	BC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	BC.DCGO_FLG" ).append("\n"); 
		query.append(",	BC.AWK_CGO_FLG" ).append("\n"); 
		query.append(",	BC.RC_FLG" ).append("\n"); 
		query.append(",	BC.BB_CGO_FLG" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK" ).append("\n"); 
		query.append(", BKG_CONTAINER BC" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("#if (${rc_flg} == 'Y')" ).append("\n"); 
		query.append("AND	BK.RC_FLG = @[rc_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bb_cgo_flg} == 'Y')" ).append("\n"); 
		query.append("AND	BK.BB_CGO_FLG = @[bb_cgo_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${awk_cgo_flg} == 'Y')" ).append("\n"); 
		query.append("AND	BK.AWK_CGO_FLG = @[awk_cgo_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dcgo_flg} == 'Y')" ).append("\n"); 
		query.append("AND	BK.DCGO_FLG = @[dcgo_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}