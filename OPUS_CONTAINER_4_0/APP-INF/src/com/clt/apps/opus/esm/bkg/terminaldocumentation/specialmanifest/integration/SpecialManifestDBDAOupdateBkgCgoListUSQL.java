/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialManifestDBDAOupdateBkgCgoListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.09
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.09.09 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOupdateBkgCgoListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_DG_CGO 테이블의 해당 CGO값을 제외처리한다.
	  * </pre>
	  */
	public SpecialManifestDBDAOupdateBkgCgoListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOupdateBkgCgoListUSQL").append("\n"); 
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
		query.append("UPDATE BKG_DG_CGO SET" ).append("\n"); 
		query.append("		CSTMS_EXPT_FLG = 'Y'" ).append("\n"); 
		query.append("       ,N1ST_PRE_VVD_CD = @[vvd_cd] -- VVD Change가 일어나는 경우에 대비하기 위해서 삭제할 당시의 VVD를 입력한다." ).append("\n"); 
		query.append("WHERE 1=1	" ).append("\n"); 
		query.append("AND	BKG_NO = @[bl_no]" ).append("\n"); 
		query.append("AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND DG_CNTR_SEQ = @[spcl_cntr_seq]" ).append("\n"); 
		query.append("AND CNTR_CGO_SEQ = @[spcl_cgo_seq]" ).append("\n"); 

	}
}